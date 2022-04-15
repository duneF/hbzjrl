package com.hbzjrl.controller;

import com.github.pagehelper.PageInfo;
import com.hbzjrl.common.NacigatePagesPlus;
import com.hbzjrl.pojo.YgPojo;
import com.hbzjrl.service.YgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;

import javax.management.QueryExp;
import java.util.HashMap;
import java.util.List;

/***
 *@Author: Yc
 *@Date:2022/4/12 9:20
 *@Description:
 */
@Controller
public class YgShow {
    @Autowired
    private YgService ygService;
    private NacigatePagesPlus nacigatePagesPlus;
    private HashMap<String, String> map;
    private List<YgPojo> ygAllList;
    private Integer count;
    private Integer limitPage;
    private Integer pagesShuRu=1;
    private YgPojo ygPojo;



    @RequestMapping("/ygShowAll")
    public String findAllByYgTable(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        nacigatePagesPlus = new NacigatePagesPlus();
        System.out.println(pageNum + "进入findALl" + pageSize);
        if (pageSize < 1) {
            pageSize = 10;
        }
        if (pageNum < 0 | pageNum > pagesShuRu) {
            pageNum = 1;
        }
        List<YgPojo> list = ygService.findAllByYgTable(pageNum, pageSize);
        Integer count = ygService.count();
        int[] ints = nacigatePagesPlus.pageNav(pageNum, count, 6);
        pagesShuRu = (int) Math.ceil((count / pageSize) + 0.5);
        PageInfo<YgPojo> pg = new PageInfo<>();
        pg.setPageNum(pageNum);
        pg.setPageSize(pageSize);
        pg.setTotal(count);
        pg.setPrePage(pageNum - 1);
        pg.setNextPage(pageNum + 1);
        pg.setNavigatepageNums(ints);
        pg.setPages(pagesShuRu);
        model.addAttribute("pg", pg);
        model.addAttribute("ygList", list);
        return "/yg-list";
    }


@RequestMapping("/ygUpdateFindById")
    public  String ygUpdateFindById(Model model,Integer id){
        ygPojo= ygService.ygUpdateFindById(id);
        System.out.println(ygPojo.toString());

        return "";
    }



}
