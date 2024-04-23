package HrApp;

public class Evaluation {
    private String evaluator;
    private short date;
    private String mentalState;
    private String notes;
    public Evaluation(String evaluator, short date)
    {
        this.evaluator = evaluator;
        this.date = date;
    }
    public String getEvaluator()
    {
        return evaluator;
    }
    public void setEvaluator(String evaluator)
    {
        this.evaluator = evaluator;
    }
    public Short getDate()
    {
        return date;
    }
    public void setDate(Short date)
    {
        this.date = date;
    }
    public String getMentalState()
    {
        return mentalState;
    }
    public void setMentalState(String mentalState)
    {
        this.mentalState = mentalState;
    }
    public String getNotes()
    {
        return notes;
    }
    public void setNotes(String notes)
    {
        this.notes = notes;
    }
}
