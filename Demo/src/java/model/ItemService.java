package model;

import jakarta.annotation.Resource;
import jakarta.persistence.*;
import java.util.List;

public class ItemService {
    
    @PersistenceContext
    EntityManager mgr;
    
    @Resource
    Query query;
    
    public ItemService(EntityManager mgr){
        this.mgr = mgr;
    }
    
    
    //Insert Item
    public boolean addItem(Item item){
        mgr.persist(item);
        return true;
    }
    
    //Retreive Item 
    public Item findItemByCode(String code){
        
        Item item = mgr.find(Item.class, code);
        return item;
    }
    
    //Delete Item
    public boolean deleteItem(String code){
        Item item = findItemByCode(code);
        if(item != null){
            mgr.remove(item);
            return true;
        }
        return false;
    }
    
    //Retreive Item List
    public List<Item> findAllItem(){
       query = mgr.createNamedQuery("Item.findAll");
       List itemList = query.getResultList();
       
       return itemList;
    }
    
    public boolean updateItem(Item item){
        Item tempItem = findItemByCode(item.getCode());
        if(tempItem != null){
            tempItem.setDescription(item.getDescription());
            tempItem.setPrice(item.getPrice());
        }
        return false;
    }
}
