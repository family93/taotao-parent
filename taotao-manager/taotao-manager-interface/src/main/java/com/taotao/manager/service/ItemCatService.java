package com.taotao.manager.service;

import com.taotao.manager.pojo.ItemCat;

import java.util.List;

/** 分页查询商品类目
 * Created by Administrator on 2017/7/24.
 */
public interface ItemCatService {
    /***
     * 分页查询商品类目
     * @param page
     * @param rows
     * @return
     */
    List<ItemCat> queryItemCatByPage(Integer page, Integer rows);
}
