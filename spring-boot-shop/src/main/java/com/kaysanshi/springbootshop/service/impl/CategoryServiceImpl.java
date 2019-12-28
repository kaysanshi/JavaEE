package com.kaysanshi.springbootshop.service.impl;

import com.kaysanshi.springbootshop.dao.CategoryMapper;
import com.kaysanshi.springbootshop.dao.ProductMapper;
import com.kaysanshi.springbootshop.domain.Category;
import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.dto.CategoryDTO;
import com.kaysanshi.springbootshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author kay三石
 * @date:2019/11/25
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;

    /**
     * 递归遍历查询出子类
     *
     * @param list
     */
    private void subcate(List <Category> list) {
        if (list == null)
            return;
        for (int i = 0; i < list.size(); i++) {
            List <Category> temp = categoryMapper.getlistBypid(list.get(i).getId());
            subcate(temp);
            list.get(i).setSublist(temp);
        }
    }

    @Override
    public List <Category> getCategoryList() {
        List <Category> list = categoryMapper.getlistBypid("-1");
        subcate(list);
        if (list != null) {
            return list;
        } else {
            return null;
        }

    }

    @Override
    public Category getCategoryListById(Category category) {
        Category categoryTemp = categoryMapper.selectOne(category);
        if (categoryTemp != null) {
            return categoryTemp;
        } else {
            return null;
        }


    }

    public Category getCategoryListById(String category) {
        Category category1 = new Category();
        category1.setId(category);
        Category categoryTemp = categoryMapper.selectOne(category1);
        if (categoryTemp != null) {
            return categoryTemp;
        } else {
            return null;
        }


    }

    @Override
    public List <Category> getCategoryListAll() {
        List <Category> list = categoryMapper.selectAll();
        for (Category category : list) {
            Product product=new Product();
            product.setCid(category.getId());
            // 获得所有的listProduct
            List<Product> listProduct = productMapper.select(product);
            int stockCount = 0;
            for (Product product1:listProduct){
                stockCount+=product1.getStock();
            }
            category.setProductCount(stockCount);
        }
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public Category addCategory(Category category) {
        category.setId(UUID.randomUUID().toString());
        if (categoryMapper.insert(category) > 0) {
            return categoryMapper.selectOne(category);
        } else {
            return null;
        }

    }

    @Override
    public Category updateCategory(Category category) {
        if (categoryMapper.updateByPrimaryKey(category) > 0) {
            return categoryMapper.selectOne(category);
        } else {
            return categoryMapper.selectOne(category);
        }

    }

    @Override
    public void deleteCategory(Category category) {
        //是父级标题
        if (!category.getPid().isEmpty() && category.getPid().equals("-1")) {
            // 获取到所有的子集
            List <Category> list = this.getCategoryList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getSublist() != null) {
                    for (int j = 0; j < list.get(i).getSublist().size(); j++) {
                        if (list.get(i).getSublist().get(j) != null) {
                            Category list1 = this.getCategoryListById(list.get(i).getSublist().get(j));
                        } else {

                        }

                    }


                } else {
                    Category category1 = list.get(i);
                    categoryMapper.delete(category1);
                }
            }

        } else {
            categoryMapper.delete(category);
        }
    }

    @Override
    public List <CategoryDTO> getCategoryDTOList() {
        List <CategoryDTO> list = categoryMapper.getCategorylistBypid("-1");
        children(list);
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public List <Category> getCategoryDTOListBycid(String cid) {
//        Category category=new Category();
//        category.setId(cid);
//        // 获得当前的category
//        Category category2=categoryMapper.selectOne(category);
//        if (category2.getPid()!="-1"){
//            Category category3=new Category();
//            category3.setId(category2.getPid()); // 获取pid
//            Category list=categoryMapper.selectOne(category3); // 获得这个categoey
//            if(list.getPid()!="-1"){
//                Category category4=categoryMapper.selectOne(list);
//                if (category4.getPid()!="-1"){
//                    Category category5=categoryMapper.selectOne(category4);
//                }
//            }
//
//            return list;
//        }

        return null;
    }

    @Override
    public List <Category> getListById(Category category1) {
        List<Category> categoryList =categoryMapper.getlistBypid(category1.getId()); // 获得所有的二级分类
        List<Category> categorie=new ArrayList <>();
        for (int i=0;i<categoryList.size();i++){
            List<Category> categories=categoryMapper.getlistBypid(categoryList.get(i).getId());// 获得三级分类
            for (Category category:categories){
                categorie.add(category);
            }
        }

        return categorie;
    }

    private void parent(Category list){
        if (list.getPid()!="-1"){


        }
    }
    private void children(List<CategoryDTO> list) {
        if (list == null)
            return;
        for (int i = 0; i < list.size(); i++) {
            List <CategoryDTO> temp = categoryMapper.getCategorylistBypid(list.get(i).getId());
            children(temp);
            list.get(i).setChildren(temp);
            list.get(i).setOpen("true");
            list.get(i).setChecked("true");
        }
    }


}
