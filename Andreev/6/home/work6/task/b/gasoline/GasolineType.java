package home.work6.task.b.gasoline;

public enum GasolineType {
    DT("ДТ"),
    AI_92("АИ-92"),
    AI_95("АИ-95"),
    AI_98("АИ-98");

    private String tittle;

    GasolineType(String tittle){
        this.tittle=tittle;
    }

    public String getTittle() {
        return tittle;
    }
}
