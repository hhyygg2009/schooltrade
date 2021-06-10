package com.yu.st.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * item
 *
 * @author
 */
@Data
@Component
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private User user;
    private Category category;
    private Condition condition;
    private State state;
    @Id
    private Integer id;
    private Comment comment;
    /**
     * 名称
     */
    private String name;
    /**
     * 价格
     */
    private Long price;
    /**
     * 商品描述
     */
    private String info;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 是否上架
     */
    private Integer stateId;
    /**
     * 商品分类
     */
    private Integer categoryId;
    /**
     * 新旧程度
     */
    private Integer conditionsId;
    /**
     * 所属用户
     */
    private Integer userId;
    private String pic1;
    private String pic2;
    private String pic3;

//    public Item(User user, Category category, Condition condition, State state, Integer id, Comment comment, String name, Long price, String info, Date createtime, Integer stateId, Integer categoryId, Integer conditionsId, Integer userId, String pic1, String pic2, String pic3) {
//        this.user = user;
//        this.category = category;
//        this.condition = condition;
//        this.state = state;
//        this.id = id;
//        this.comment = comment;
//        this.name = name;
//        this.price = price;
//        this.info = info;
//        this.createtime = createtime;
//        this.stateId = stateId;
//        this.categoryId = categoryId;
//        this.conditionsId = conditionsId;
//        this.userId = userId;
//        this.pic1 = pic1;
//        this.pic2 = pic2;
//        this.pic3 = pic3;
//    }

//    private void writeObject(ObjectOutputStream out) throws IOException {
//        String jsonString=JSON.toJSONString(this);
//        out.writeObject(jsonString);
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        String jsonString= (String) in.readObject();
//        Item item=JSON.parseObject(jsonString,Item.class);
//
//        this.user = item.user;
//        this.category = item.category;
//        this.condition = item.condition;
//        this.state = item.state;
//        this.id = item.id;
//        this.comment = item.comment;
//        this.name = item.name;
//        this.price = item.price;
//        this.info = item.info;
//        this.createtime = item.createtime;
//        this.stateId = item.stateId;
//        this.categoryId = item.categoryId;
//        this.conditionsId = item.conditionsId;
//        this.userId = item.userId;
//        this.pic1 = item.pic1;
//        this.pic2 = item.pic2;
//        this.pic3 = item.pic3;
//    }
}