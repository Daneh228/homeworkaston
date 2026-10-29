package ru.aston.hometask3.builder;

public class Car {

    private String model;
    private String body;
    private String interior;
    private String paint;

    public Car(){
        super();
    }

    public Car(String model, String body, String interior, String paint) {
        this.model = model;
        this.body = body;
        this.interior = interior;
        this.paint = paint;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", body='" + body + '\'' +
                ", interior='" + interior + '\'' +
                ", paint='" + paint + '\'' +
                '}';
    }

    public boolean isValid(){
        return (model != null && !model.trim().isEmpty()) && (body != null && !body.trim().isEmpty()) &&
                (interior != null && !interior.trim().isEmpty()) && (paint != null && !paint.trim().isEmpty());
    }


}
