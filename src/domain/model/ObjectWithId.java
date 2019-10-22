package domain.model;

public abstract class ObjectWithId {
    private Integer id;



    public ObjectWithId(int id){
        setId(id);
    }


    public ObjectWithId(){
        this(new RandomIdGenerator().getRandomId());
    }

    public int getId() {
        return id;
    }


    public void setId(int id){
        this.id = id;
    }


}
