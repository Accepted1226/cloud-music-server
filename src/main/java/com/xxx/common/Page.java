//package com.xxx.common;
//
//import com.github.pagehelper.PageInfo;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Page<T> {
//    // 当前页
//    private Integer page = 1;
//    // 下一页
//    private Integer next = 2;
//    // 每页显示的总条数
//    private Integer size = 10;
//    // 总条数
//    private Long total;
//    //总页数
//    private int pages;
//    // 分页结果
//    private List<T> data;
//
//    public Page(PageInfo<T> pageInfo) {
//        this.page = pageInfo.getPageNum();
//        this.next = pageInfo.getPageNum()+1;
//        this.size = pageInfo.getPageSize();
//        this.total = pageInfo.getTotal();
//        this.pages = pageInfo.getPages();
//        this.data = pageInfo.getList();
//        //System.out.println(this.size);
//    }
//
//}


package com.xxx.common;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Page<T> {
    // 当前页
    private Integer page = 1;
    // 每页显示的总条数
    private Integer size = 10;
    // 总条数
    private Long total;
    //总页数
    private int pages;
    private int next;
    // 分页结果
    private List<T> data;

    public Page(PageInfo<T> pageInfo) {
        this.page = pageInfo.getPageNum();
        this.size = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
        this.next = pageInfo.getNextPage();
        this.pages = pageInfo.getPages();
        this.data = pageInfo.getList();
    }

}
