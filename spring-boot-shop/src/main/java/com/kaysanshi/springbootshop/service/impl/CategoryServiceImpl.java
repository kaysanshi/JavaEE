package com.kaysanshi.springbootshop.service.impl;

import com.kaysanshi.springbootshop.dao.CategoryMapper;
import com.kaysanshi.springbootshop.domain.Category;
import com.kaysanshi.springbootshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/11/25
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 递归遍历查询出子类
     * @param list
     */
    private void subcate(List<Category> list) {
        if (list == null)
            return ;
        for (int i = 0; i < list.size(); i++) {
            List<Category> temp = categoryMapper.getlistBypid(Integer.parseInt(list.get(i).getId()));
            subcate(temp);
            list.get(i).setSublist(temp);
        }
    }
    @Override
    public List<Category> getCategoryList() {
        List<Category> list = categoryMapper.getlistBypid(-1);
        subcate(list);
        if (list!=null){
            return list;
        }else{
            return null;
        }

    }

    @Override
    public Category getCategoryListById(Category category) {
        Category categoryTemp=categoryMapper.selectOne(category);
        if (categoryTemp!=null){
            return categoryTemp;
        }else {
            return null;
        }


    }

    public Category getCategoryListById(String category) {
        Category category1=new Category();
        category1.setId(category);
        Category categoryTemp=categoryMapper.selectOne(category1);
        if (categoryTemp!=null){
            return categoryTemp;
        }else {
            return null;
        }


    }

    @Override
    public List <Category> getCategoryListAll() {
        List<Category> list=categoryMapper.selectAll();
        if (list!=null){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public Category addCategory(Category category) {
        if (categoryMapper.insert(category)>0){
            return categoryMapper.selectOne(category);
        }else{
            return null;
        }

    }

    @Override
    public Category updateCategory(Category category) {
        if (categoryMapper.updateByPrimaryKey(category)>0){
            return categoryMapper.selectOne(category);
        }else{
            return categoryMapper.selectOne(category);
        }

    }

    @Override
    public void deleteCategory(Category category) {
        //是父级标题
        if (!category.getPid().isEmpty()&&category.getPid().equals("-1")){
            // 获取到所有的子集
            List<Category> list=this.getCategoryList();
            for (int i=0;i<list.size();i++){
                if (list.get(i).getSublist()!=null){
                    for (int j=0; j<list.get(i).getSublist().size();j++){
                        if (list.get(i).getSublist().get(j)!=null){
                            Category list1=this.getCategoryListById(list.get(i).getSublist().get(j));
                        }else{

                        }

                    }


                }else{
                    Category category1=list.get(i);
                    categoryMapper.delete(category1);
                }
            }

        }else{
            categoryMapper.delete(category);
        }
    }


}
