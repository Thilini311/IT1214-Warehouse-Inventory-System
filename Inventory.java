import java.util.*;
public class Inventory{
    private HashMap<String, Item>items;

    public Inventory(){
        items=new HashMap<>();
    }

    public void addItem(Item item){
        if(items.containsKey(item.getItemId())){
            System.out.println("Item already exists!");
        }else{
            items.put(item.getItemId(),item);
            System.out.println("Item added successfully.");
        }
    }

    public void removeItem(String itemId){
        if(items.remove(itemId)!= null){
            System.out.println("Item removed.");
        }else{
            System.out.println("Item not found.");
        }
    }

    public void updateQuantity(String itemId, int quantity){
        Item item=items.get(itemId);
        if(item!= null){
            item.setQuantity(quantity);
            System.out.println("Quantity updated.");
        }else{
            System.out.println("Item not found.");
        }
    }

    public Item searchById(String itemId){
        return items.get(itemId);
    }

    public List<Item>searchByName(String name){
        List<Item>result=new ArrayList<>();
        for(Item item:items.values()){
            if(item.getItemName().equalsIgnoreCase(name)){
                result.add(item);
            }
        }
        return result;
    }

    public void displayAll(){
        if(items.isEmpty()){
            System.out.println("Inventory is empty.");
        }else{
            for(Item item : items.values()){
                System.out.println(item);
            }
        }
    }
}