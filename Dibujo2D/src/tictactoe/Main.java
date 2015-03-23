package tictactoe;
	
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application{

	private Label estado;
	private char turno = 'X';
	private char tablero[][]={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	private Group root;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Tic Tac Toe");
        root=new Group();
        Scene scene=new Scene(root,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        dibujarTablero(root);
        scene.setOnMouseClicked(e->ponerMarca(e));
	}
	
	private void ponerMarca(MouseEvent e) {
		//System.out.println("Entrando en ponerMarca");
		int[] pos=obtenerPosición(e.getSceneX(),e.getSceneY());
		int x=pos[0],y=pos[1];
		System.out.println("Posición: " + x + y);
		
      if (tablero[x][y] == ' ' && turno!=' ') {
          dibuja(turno,x,y);
          tablero[x][y]=turno;
          
          if (esGanador(turno)) {
            estado.setText(turno + " ha ganado!!");
            turno = ' ';
          }
          else if (tableroLleno()) {
            estado.setText("El tablero está lleno, ¡¡ EMPATE !!");
            turno = ' ';
          }
          else {
            turno= (turno == 'X') ? 'O' : 'X';
            estado.setText("Turno para " + turno);
          }
        }
	}

	private boolean esGanador(char jugador) {
		for (int i = 0; i < 3; i++)
		      if (tablero[i][0] == jugador
		          && tablero[i][1] == jugador
		          && tablero[i][2] == jugador) {
		        return true;
		      }

		    for (int j = 0; j < 3; j++)
		      if (tablero[0][j] ==  jugador
		          && tablero[1][j] == jugador
		          && tablero[2][j] == jugador) {
		        return true;
		      }

		    if (tablero[0][0] == jugador 
		        && tablero[1][1] == jugador        
		        && tablero[2][2] == jugador) {
		      return true;
		    }

		    if (tablero[0][2] == jugador
		        && tablero[1][1] == jugador
		        && tablero[2][0] == jugador) {
		      return true;
		    }

		return false;
	}
	

	private void dibuja(char jugador, int x, int y) {
		
		  Node figura=null;
	      if (jugador == 'X') {
	    	  Line line1 = new Line(25, 25, 
	        		  75, 75);
	    	  Line line2 = new Line(75, 25, 
	        		  25, 75);
	    	  Shape xShape=Shape.union(line1,line2);
	    	  
	    	  xShape.setStrokeLineCap(StrokeLineCap.ROUND);
	    	  xShape.setStrokeWidth(20);
	    	  xShape.setStroke(Color.RED);
	    	  xShape.setEffect(new DropShadow(8,2,2,Color.DARKRED));
	    	  
	          figura=xShape; 
	        }
	        else if (jugador == 'O') {
	        	Circle circle = new Circle(50, 
	    	            50, 30);  
	          circle.setStroke(Color.BLUE);
	          circle.setStrokeWidth(20);
	          circle.setFill(null);
	          circle.setEffect(new DropShadow(8,2,2,Color.DARKBLUE));
	          
	          figura=circle;
	        }
	      
	      root.getChildren().add(figura);
	      figura.setTranslateX(100+x*100);
	      figura.setTranslateY(100+y*100);
		
	}

	public void dibujarTablero(Group root) {
		Line[] lines={	new Line(200,100,200,400),
						new Line(300,100,300,400),
						new Line(100,200,400,200),
						new Line(100,300,400,300)};
		DropShadow effect=new DropShadow(8,2,2,Color.rgb(60, 60, 60, 0.4));
		for(Line l:lines) {
			l.setEffect(effect);
			l.setStrokeWidth(5);
			root.getChildren().add(l);
		}
		
		estado = new Label("¡¡Comencemos, turno de X!!");
		estado.setEffect(new DropShadow(4,2,2,Color.rgb(60, 60, 60, 0.4)));
		System.out.println(Font.getFontNames());
		estado.setFont(Font.font("Droid Sans", FontWeight.BOLD,24));
		estado.setTextFill(Color.DARKMAGENTA);
		root.getChildren().add(estado);
		estado.widthProperty().addListener(
				( o, oldVal, newVal) ->	estado.setTranslateX(250-newVal.intValue()/2));
		//estado.setTranslateX(250-estado.getLayoutBounds().getWidth()/2);
		estado.heightProperty().addListener(
				( o, oldVal, newVal) ->	estado.setTranslateY(newVal.intValue()));		
		
	}
	
	public int[] obtenerPosición(double d, double e) {
		int[] posicion={0,0};
		
		if (d>=200) posicion[0]++;
		if (d>=300) posicion[0]++;
		if (e>=200) posicion[1]++;
		if (e>=300) posicion[1]++;
		return posicion;
	}

	public boolean tableroLleno() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (tablero[i][j]== ' ')
					return false;
		return true;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}