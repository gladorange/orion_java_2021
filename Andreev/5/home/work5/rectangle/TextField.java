package home.work5.rectangle;

public class TextField extends Rectangle {
    private String text;

    public TextField(int x, int y, int width, int height, String caption) {
        super(x, y, width, height, caption);
        this.text = getRandomText();
    }

    private String getRandomText() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));

        }

        return sb.toString();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
