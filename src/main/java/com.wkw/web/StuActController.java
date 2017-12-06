package com.wkw.web;

import com.wkw.dto.SearchDto;
import com.wkw.dto.StuActExecution;
import com.wkw.dto.json.JsonData;
import com.wkw.dto.json.ListJson;
import com.wkw.entity.BookEntity;
import com.wkw.entity.BorrowBookEntity;
import com.wkw.entity.OrderBookEntity;
import com.wkw.entity.StudentEntity;
import com.wkw.enums.SearchBookType;
import com.wkw.enums.StuActStatEnum;
import com.wkw.exception.StuActEp;
import com.wkw.exception.SystemEp;
import com.wkw.service.StuActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * created by wkw
 */
@Controller //spring装配
@RequestMapping("/lib/stu")
public class StuActController {

    @Autowired
    private StuActService stuActService;

    //我的主页
    @RequestMapping(value = "/myHomepage")
    public String myHomepage(Model model, HttpSession session){
        //查询得到学生信息
        StudentEntity studentEntity = (StudentEntity) session.getAttribute("user");
        //System.out.println(studentEntity);
        SearchDto searchDto = new SearchDto();
        List<SearchBookType> list = new ArrayList<SearchBookType>();

        for(SearchBookType s:SearchBookType.values()){
            list.add(s);
        }
        searchDto.setSearchType(list);//todo 得到真正的信息

        model.addAttribute("searchDto",searchDto);
        model.addAttribute("myInfo",studentEntity);

        return "myHomepage";
    }

    //查看借书表
    @RequestMapping(value = "/borrowList")
    public String getMyBorrow(Model model,HttpSession session){
        StudentEntity studentEntity = (StudentEntity) session.getAttribute("user");
        List<BorrowBookEntity> borrowList= stuActService.queryBorrowBook(studentEntity.getStuID());
        model.addAttribute("borrowList",borrowList);
        return "borrowList";
    }

    //查看预约表
    @RequestMapping(value = "/orderList")
    public String getMyOrder(Model model,HttpSession session){
        StudentEntity studentEntity = (StudentEntity) session.getAttribute("user");
        List<OrderBookEntity> orderList = stuActService.queryOrderBook(studentEntity.getStuID());
        model.addAttribute("orderList",orderList);
        return "orderList";
    }


    //搜索图书 --搜索页面
    /**
     * 传入信息包括
     * 搜索类型 类型的关键字 搜索排名等等信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/search")
    public String searchBook(Model model){
        SearchDto searchDto = new SearchDto();
        model.addAttribute("searchDto",searchDto);
        //.jsp + model = ModelAndView
        return "search"; //  /WEB_INF/jsp/search.jsp
    }

    //得到搜索列表 --显示图书页面
    @RequestMapping(value = "/{type}/{key}/result")
    public String searchResult(@PathVariable("type") String type,
                               @PathVariable("key") String key, Model model){
        List<BookEntity> searchList = stuActService.queryBook(SearchBookType.stateof(type),key);
        model.addAttribute("searchList",searchList);

        return "searchResult";
    }

    //书的详情页
    @RequestMapping(value = "/{bookISBN}/bookDetail")
    public String bookDetail(@PathVariable("bookISBN") String bookISBN,Model model){
        BookEntity bookEntity= stuActService.queryByISBN(bookISBN);
        if(bookEntity==null)//todo 错误页面
            return "redirect:/lib/stu/myHomepage";

        model.addAttribute("bookEntity",bookEntity);
        return "bookDetail";
    }

    //借书操作
    @RequestMapping(value = "/{bookISBN}/borrow")
    @ResponseBody
    public JsonData borrowBook(@PathVariable("bookISBN") String bookISBN,
                                                HttpSession session){
        StudentEntity studentEntity = (StudentEntity) session.getAttribute("user");
        try{
            StuActExecution execution=stuActService.borrowBook(studentEntity.getStuID(),bookISBN);
            return new JsonData<StuActExecution>(true,execution);
        }catch(StuActEp ep){
            return new JsonData<StuActExecution>(false,ep.getState().getStatInfo());
        }catch (Exception e){
            return new JsonData<StuActExecution>(false,StuActStatEnum.INNER_ERROR.getStatInfo());
        }
    }

    //还书操作
    @RequestMapping(value = "/{borrowID}/return")
    @ResponseBody
    public JsonData returnBook(@PathVariable("borrowID") int borrowID){
        try{
            StuActExecution stuActExecution=stuActService.returnBook(borrowID);
            return new JsonData(true,stuActExecution);
        }catch (StuActEp ep){
            return new JsonData(false,ep.getState().getStatInfo());
        }catch(SystemEp ep){
            return new JsonData(false,ep.getMessage());
        }catch(Exception ep){
            return new JsonData(false,ep.getMessage());
        }
    }

    //预约操作 TODO
    @RequestMapping(value = "/{bookISBN}/order")
    @ResponseBody
    public JsonData orderBook(@PathVariable("bookISBN") String bookISBN,HttpSession session){
        StudentEntity studentEntity = (StudentEntity) session.getAttribute("user");
        try{
            StuActExecution execution=stuActService.orderBook(studentEntity.getStuID(),bookISBN);
            return new JsonData(true,execution);
        }catch (StuActEp ep){
            return new JsonData(false,ep.getState().getStatInfo());
        }catch(Exception ep){
            return new JsonData(false,ep.getMessage());
        }
    }


    //取消预约
    @RequestMapping(value = "/{ID}/{ISBN}/cancelOrder")
    @ResponseBody
    public JsonData cancelOrder(@PathVariable("ID") String ID,@PathVariable("ISBN") String ISBN){
        try{
            StuActExecution execution=stuActService.cancelOrder(ID,ISBN);
            return new JsonData(true,execution);
        }catch(StuActEp ep){
            return new JsonData(false,ep.getState().getStatInfo());
        }
    }
}
