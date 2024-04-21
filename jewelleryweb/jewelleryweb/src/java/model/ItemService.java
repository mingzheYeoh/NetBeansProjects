package model;

import java.util.List;
import jakarta.annotation.Resource;
import jakarta.persistence.*;

public class ItemService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public ItemService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addItem(Item item) {
        mgr.persist(item);
        return true;
    }

    public Item findItemByCode(String code) {
        Item item = mgr.find(Item.class, code);
        return item;
    }

    public boolean deleteItem(String code) {
        Item item = findItemByCode(code);
        if (item != null) {
            mgr.remove(item);
            return true;
        }
        return false;
    }

    public List<Item> findAll() {
        List itemList = mgr.createNamedQuery("Item.findAll").getResultList();
        return itemList;
    }

    public boolean updateItem(Item item) {
        Item tempItem = findItemByCode(item.getCode());
        if (tempItem != null) {
            tempItem.setDescription(item.getDescription());
            tempItem.setPrice(item.getPrice());
            return true;
        }
        return false;
    }
}
