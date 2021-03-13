package com.example.vipul.hireforwork;

public class RowItem {

    private String item_name;
    private int item_pic_id,item_rat_id;
    private  String description;

    public RowItem(String item_name, int item_pic_id, String description,int item_rat_id){
        this.item_name=item_name;
        this.item_pic_id=item_pic_id;
        this.description=description;
        this.item_rat_id=item_rat_id;
    }

    public String getItem_name(){return item_name;}
    public void setItem_name(String item_name){this.item_name=item_name;}

    public int getItem_pic_id() { return item_pic_id; }
    public void setItem_pic_id(int item_pic_id){this.item_pic_id=item_pic_id;}

    public String getDescription(){return description;}
    public  void setDescription(String description){this.description=description;}

    public int getItem_rat_id() { return item_rat_id; }
    public void setItem_rat_id_id(int item_rat_id){this.item_rat_id=item_rat_id;}

}
