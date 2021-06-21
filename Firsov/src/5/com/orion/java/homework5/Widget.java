package com.orion.java.homework5;

import com.orion.java.homework5.exception.ELementsOverlapException;

import java.util.ArrayList;
import java.util.HashMap;


public class Widget {


    public static int ID_WIDGET = 0;

    final static boolean IS_ACTIVE_DEFAULT = false;
    protected int   x;
    protected int   y;
    protected int   w;
    protected int   h;
    private int id;

    private com.orion.java.homework5.Widget prev_;
    private com.orion.java.homework5.Widget next_;
    protected     boolean isActive;
    protected String caption;

    public Widget(int x, int y, int w, int h, boolean isActive, String caption) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.prev_ = null;
        this.next_ = null;
        this.isActive = isActive;
        this.caption = caption;
        this.id = ID_WIDGET;
        ID_WIDGET++;
    }

    public String getCaption() {
        return caption;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public  void update(Widget updatedWidget){}

    public static class State{
        private static State instance;
        private State(){
            listeners = new HashMap<>();
        }

        public static State getInstance() {
            if (instance == null) {
                instance = new State();
            }
            return instance;
        }
        public boolean isWidgetsEguals(Widget wgt1,Widget wgt2){
            System.out.println(wgt1.id+" "+ wgt1.caption);
            System.out.println(wgt2.id+ " "+ wgt2.caption);
            return (wgt1.id == wgt2.id?true:false);
        }

        private HashMap<Integer, ArrayList<Integer>> listeners;
        private void addListener( int idUpdated,int idListener){
            System.out.println("addListener updated wgt"+idUpdated+" widget id "+ idListener);
            try {
                listeners.get( idUpdated).add(idListener);
            }catch (NullPointerException e){
                listeners.put( idUpdated,(new ArrayList<>()));
                listeners.get( idUpdated).add(idListener);
            }
        }


        public void addListener(Widget updatedWidget,Widget widget){
               addListener( updatedWidget.id,widget.id);
        }

        /**
         * При изменении состояния виджета, можно обновить другие виджеты,куторые подписались на этот виджет.
         * @param id
         *
         * Пример.При нажатии на кнопкуможно ихменять состояния CheckBox's.
         */
        private   void update(int id){
            System.out.println("update id "+id);
            Widget.UI ui = Widget.UI.getInstance();
            ArrayList<Integer> listener =  listeners.get(id);
            if(listener != null){
                for (Integer list:listener) {
                    Widget widget = ui.getAllElements().get(list);
                    if(widget != null){
                        widget.update(ui.getAllElements().get(id));
                    }
                }
            }
        }
        public   void update(Widget updatedWidget){
            update(updatedWidget.id);
        }
    }
    public static class UI{

        private static  Widget.UI instance;
        private UI(){
            cells_ =  new  Widget[NUM_CELLS][NUM_CELLS];
            widgetHashMap = new HashMap<>();
            for (int x = 0; x < NUM_CELLS; x++) {
                for (int y = 0; y < NUM_CELLS; y++) {
                    cells_[x][y] = null;
                }
            }
        }
        public static com.orion.java.homework5.Widget.UI getInstance() {
            if (instance == null) {
                instance = new com.orion.java.homework5.Widget.UI();
            }
            return instance;
        }

        //Количество клеток
       public static int NUM_CELLS = 100;
        //В одной клетке может быть только один элемент
        private final int CELL_SIZE = 1;
        private com.orion.java.homework5.Widget cells_[][];
        private  HashMap<Integer, com.orion.java.homework5.Widget> widgetHashMap;

        public void addElement( Widget widget) throws ELementsOverlapException,ArrayIndexOutOfBoundsException {
            System.out.println("try to add id"+widget.id+" name "+ widget.caption);
            for(int xi = widget.x;xi < widget.x+widget.w;xi++ ){
                for(int yi = widget.y;yi < widget.y+widget.h;yi++ ){
                    // Определяем в какой ячейке сетки мы находимся.
                    int cellX = (xi / CELL_SIZE);
                    int cellY = (yi / CELL_SIZE);
                    if( cells_[cellX][cellY] != null){
                        throw new ELementsOverlapException("Error:The element |"+widget.caption +"|can't be added."
                                +"There is the element |"+cells_[cellX][cellY].caption + "|");
                    }
                    // Добавляем в начало списка найденной ячейки.
                    widget.prev_ = null;
                    widget.next_ = cells_[cellX][cellY];
                    cells_[cellX][cellY] = widget;

                    if (widget.next_ != null) {
                        widget.next_.prev_ = widget;
                    }
                }
            }
            widgetHashMap.put(widget.id,widget);
        }
        public  HashMap<Integer, Widget>getAllElements(){
            return widgetHashMap;
        }
    }
}
