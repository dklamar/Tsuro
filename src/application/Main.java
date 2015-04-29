package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

	public class Main extends Application {
		// Percentage of tile space vs entire board
		public final double tilePercent = 0.1577181208;
		public final double spacePercent = 0.02572706935;
		public ArrayList<ArrayList<Tile>> board;
		public ArrayList<Figure> figures;
		public ArrayList<Tile> deck;
		public BorderPane root;
		public int timesPressed0;
		public int timesPressed1;
		public int timesPressed2;
		public int rotateAmount0;
		public int rotateAmount1;
		public int rotateAmount2;
		public FlowPane flow = new FlowPane();
		public final Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		@Override
		public void start(Stage primaryStage) {
			try {
				root = new BorderPane();
				root.setCenter(addGridPane());
				StackPane stackPaneLeft = new StackPane();
				stackPaneLeft.setMinWidth(visualBounds.getWidth() / 4);

				root.setLeft(stackPaneLeft);
				
				createBoard(visualBounds);
				createDeck();

				Figure player = new Figure(1,visualBounds,spacePercent);
				figures.add(player);
				player.place(0,0,0);
				drawCard(player);
				drawCard(player);
				drawCard(player);

				Figure cpu = new Figure(2,visualBounds,spacePercent);
				figures.add(cpu);
				cpu.place(0,0,1);
				drawCard(cpu);
				drawCard(cpu);
				drawCard(cpu);
				root.setRight(addFlowPane((GridPane)root.getCenter(), player));
			
				Scene scene = new Scene(root,visualBounds.getWidth(),visualBounds.getHeight());
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		public void drawCard(Figure f) {
			if(deck.size()>0) {
				f.hand.add(deck.remove(0));
			}
		}

		public void createDeck() {
			deck = new ArrayList<Tile>();
			int[] tempPairs1 = {1,0,3,2,7,6,5,4};
			deck.add(new Tile(tempPairs1,1,visualBounds, tilePercent));
			int[] tempPairs2 = {3,5,6,0,7,1,2,4}; //Done
			deck.add(new Tile(tempPairs2,2,visualBounds, tilePercent));
			int[] tempPairs3 = {1,0,5,6,7,2,3,4}; //Done
			deck.add(new Tile(tempPairs3,3,visualBounds, tilePercent));
			int[] tempPairs4 = {4,7,3,2,0,6,5,1}; //Done
			deck.add(new Tile(tempPairs4,4,visualBounds, tilePercent));
			int[] tempPairs5 = {4,7,6,5,0,3,2,1}; //Done
			deck.add(new Tile(tempPairs5,5,visualBounds, tilePercent));
			int[] tempPairs6 = {7,2,1,6,5,4,3,0}; //Done
			deck.add(new Tile(tempPairs6,6,visualBounds, tilePercent));
			int[] tempPairs7 = {6,5,4,7,2,1,0,3}; //Done
			deck.add(new Tile(tempPairs7,7,visualBounds, tilePercent));
			int[] tempPairs8 = {3,2,1,0,6,7,4,5}; //Done
			deck.add(new Tile(tempPairs8,8,visualBounds, tilePercent));
			int[] tempPairs9 = {2,7,0,5,6,3,4,1}; //Done
			deck.add(new Tile(tempPairs9,9,visualBounds, tilePercent));
			int[] tempPairs10 = {3,6,5,0,7,2,1,4}; //Done
			deck.add(new Tile(tempPairs10,10,visualBounds, tilePercent));
			int[] tempPairs11 = {5,4,7,6,1,0,3,2}; //Done
			deck.add(new Tile(tempPairs11,11,visualBounds, tilePercent));
			int[] tempPairs12 = {2,6,0,7,5,4,1,3}; //Done
			deck.add(new Tile(tempPairs12,12,visualBounds, tilePercent));
			int[] tempPairs13 = {7,3,4,1,2,6,5,0}; //Done
			deck.add(new Tile(tempPairs13,13,visualBounds, tilePercent));
			int[] tempPairs14 = {1,0,4,6,2,7,3,5}; //Done
			deck.add(new Tile(tempPairs14,14,visualBounds, tilePercent));
			int[] tempPairs15 = {5,2,1,6,7,0,3,4}; //Done
			deck.add(new Tile(tempPairs15,15,visualBounds, tilePercent));
			int[] tempPairs16 = {7,2,1,4,3,6,5,0}; //Done
			deck.add(new Tile(tempPairs16,16,visualBounds, tilePercent));
			int[] tempPairs17 = {3,2,1,0,7,6,5,4}; //Done
			deck.add(new Tile(tempPairs17,17,visualBounds, tilePercent));
			int[] tempPairs18 = {1,0,7,6,5,4,3,2}; //Done
			deck.add(new Tile(tempPairs18,18,visualBounds, tilePercent));
			int[] tempPairs19 = {5,3,6,1,7,0,2,4}; //Done
			deck.add(new Tile(tempPairs19,19,visualBounds, tilePercent));
			int[] tempPairs20 = {3,4,5,1,0,2,7,6}; //Done
			deck.add(new Tile(tempPairs20,20,visualBounds, tilePercent));
			int[] tempPairs21 = {3,5,7,0,6,1,4,2}; //Done
			deck.add(new Tile(tempPairs21,21,visualBounds, tilePercent));
			int[] tempPairs22 = {7,3,5,1,6,2,4,0}; //Done
			deck.add(new Tile(tempPairs22,22,visualBounds, tilePercent));
			int[] tempPairs23 = {5,3,7,1,6,0,4,2}; //Done
			deck.add(new Tile(tempPairs23,23,visualBounds, tilePercent));
			int[] tempPairs24 = {4,2,1,7,0,6,5,3}; //Done
			deck.add(new Tile(tempPairs24,24,visualBounds, tilePercent));
			int[] tempPairs25 = {2,4,0,7,1,6,5,3}; //Done
			deck.add(new Tile(tempPairs25,25,visualBounds, tilePercent));
			int[] tempPairs26 = {5,4,6,7,1,0,2,3}; //Done
			deck.add(new Tile(tempPairs26,26,visualBounds, tilePercent));
			int[] tempPairs27 = {1,0,7,5,6,3,4,2}; //Done
			deck.add(new Tile(tempPairs27,27,visualBounds, tilePercent));
			int[] tempPairs28 = {1,0,3,2,5,4,7,6}; //Done
			deck.add(new Tile(tempPairs28,28,visualBounds, tilePercent));
			int[] tempPairs29 = {4,2,1,6,0,7,3,5}; //Done
			deck.add(new Tile(tempPairs29,29,visualBounds, tilePercent));
			int[] tempPairs30 = {1,0,6,7,5,4,2,3}; //Done
			deck.add(new Tile(tempPairs30,30,visualBounds, tilePercent));
			int[] tempPairs31 = {4,5,6,7,0,1,2,3}; //Done
			deck.add(new Tile(tempPairs31,31,visualBounds, tilePercent));
			int[] tempPairs32 = {1,0,6,5,7,3,2,4}; //Done
			deck.add(new Tile(tempPairs32,32,visualBounds, tilePercent));
			int[] tempPairs33 = {1,0,4,5,2,3,7,6}; //Done
			deck.add(new Tile(tempPairs33,33,visualBounds, tilePercent));
			int[] tempPairs34 = {3,6,4,0,2,7,1,5}; //Done
			deck.add(new Tile(tempPairs34,34,visualBounds, tilePercent));
			int[] tempPairs35 = {2,5,0,4,3,1,7,6}; //Done
			deck.add(new Tile(tempPairs35,35,visualBounds, tilePercent));
			long seed = System.nanoTime();
			Collections.shuffle(deck, new Random(seed));
			int[] tempPairs0 = {8,8,8,8,8,8,8,8}; // Dragon Tile, nonsense values
			deck.add(new Tile(tempPairs0,36,visualBounds,tilePercent)); // Dragon Tile is Tile 36
		}

		public void createBoard(Rectangle2D visualBounds) {
			figures = new ArrayList<Figure>();
			board = new ArrayList<ArrayList<Tile>>();
			for (int i=0; i<6; i++) {
				ArrayList<Tile> tempArrayList = new ArrayList<Tile>();
				for (int j=0; j<6; j++) {
					int[] tempPairs = {-1,-1,-1,-1,-1,-1,-1,-1};
					Tile tempTile = new Tile(tempPairs,-1,visualBounds,tilePercent);
					tempArrayList.add(tempTile);
				}
				board.add(tempArrayList);
			}
		}


		public GridPane addGridPane() {
			GridPane grid = new GridPane();
			Image boardPic = new Image("gameboard.jpg",visualBounds.getWidth() / 2,visualBounds.getWidth() / 2,false,false);
			BackgroundImage board = new BackgroundImage(boardPic,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			grid.setBackground(new Background(board));
			Pane topLeftCorner = new Pane();
			topLeftCorner.setPrefSize(Math.ceil((visualBounds.getWidth() / 2) * spacePercent), Math.ceil(visualBounds.getWidth() / 2 * spacePercent));
			grid.add(topLeftCorner, 0, 0);
			Pane topRightCorner = new Pane();
			topRightCorner.setPrefSize(Math.ceil((visualBounds.getWidth() / 2) * spacePercent), Math.ceil(visualBounds.getWidth() / 2 * spacePercent));
			grid.add(topRightCorner, 7, 0);
			Pane bottomLeftCorner = new Pane();
			bottomLeftCorner.setPrefSize(Math.ceil((visualBounds.getWidth() / 2) * spacePercent), Math.ceil(visualBounds.getWidth() / 2 * spacePercent));
			grid.add(bottomLeftCorner, 0, 7);
			Pane bottomRightCorner = new Pane();
			bottomRightCorner.setPrefSize(Math.ceil((visualBounds.getWidth() / 2) * spacePercent), Math.ceil(visualBounds.getWidth() / 2 * spacePercent));
			grid.add(bottomRightCorner, 7, 7);
			for(int i=1;i<7;i++) {
				Pane newPane = new Pane();
				newPane.setPrefSize(Math.ceil((visualBounds.getWidth() / 2) * tilePercent), Math.ceil(visualBounds.getWidth() / 2 * spacePercent));
				grid.add(newPane, i, 0);
			}

			for(int i=1;i<7;i++) {
				Pane newPane = new Pane();
				newPane.setPrefSize(Math.ceil((visualBounds.getWidth() / 2) * tilePercent), Math.ceil(visualBounds.getWidth() / 2 * spacePercent));
				grid.add(newPane, i, 7);
			}
			
			for(int i=1;i<7;i++) {
				Pane newPane = new Pane();
				newPane.setPrefSize(Math.ceil((visualBounds.getWidth() / 2) * spacePercent), Math.ceil(visualBounds.getWidth() / 2 * tilePercent));
				grid.add(newPane, 0, i);
			}

			for(int i=1;i<7;i++) {
				Pane newPane = new Pane();
				newPane.setPrefSize(Math.ceil((visualBounds.getWidth() / 2) * spacePercent), Math.ceil(visualBounds.getWidth() / 2 * tilePercent));
				grid.add(newPane, 7, i);
			}
			//grid.setGridLinesVisible(true);
			return grid;
		}

		public FlowPane addFlowPane(GridPane g, Figure player) {
			
			flow.setPadding(new Insets(5, 0, 5, 0));
			flow.setVgap(6);
			flow.setHgap(4);
			flow.setPrefWrapLength(170); // preferred width allows for two columns
			//flow.setStyle("-fx-background-color: DAE6F3;");
			//StackPane stackPaneRight = new StackPane();
			//stackPaneRight.setMinWidth(visualBounds.getWidth() / 4);
			final ToggleGroup group = new ToggleGroup();
			int numberOfTiles =  player.hand.size();
			if(!player.alive){
				Button dead = new Button();
		    	dead.setText("You Died");
		    	flow.getChildren().add(dead);
			}
			else{
				if(numberOfTiles==0){
					Button btnNoTiles = new Button();
					btnNoTiles.setText("Out of Tiles");
					flow.getChildren().add(btnNoTiles);
				}
				if(numberOfTiles>0){
					Image tile0 = player.hand.get(0).image;
					ImageView iv0 = new ImageView(tile0);
					Button btn0 = new Button();
					btn0.setText("Click to Rotate");
					btn0.setOnAction((event)->{
						timesPressed0+=1;
						int r = timesPressed0%4;
						if(r==0){
							iv0.setRotate(0);
							if(timesPressed0!=0){
								rotateAmount0=360;
							}
							else{
								rotateAmount0=0;
							}
						}
						else if(r==1){
							iv0.setRotate(90);
							rotateAmount0=90;
						}
						else if(r==2){
							iv0.setRotate(180);
							rotateAmount0=180;
						}
						else if(r==3){
							iv0.setRotate(270);
							rotateAmount0=270;
						}
					});
					RadioButton rb0 = new RadioButton();
					rb0.setGraphic(iv0);
					rb0.setText("Select Tile 1");
					rb0.setToggleGroup(group);
					int data0 = 0;
					rb0.setUserData(data0);
					flow.getChildren().add(rb0);
					flow.getChildren().add(btn0);
				}
				if(numberOfTiles>1){
					Image tile1 = player.hand.get(1).image;
					ImageView iv1 = new ImageView(tile1);
					Button btn1 = new Button();
					btn1.setText("Click to Rotate");
					btn1.setOnAction((event)->{
						timesPressed1+=1;
						int r = timesPressed1%4;
						if(r==0){
							iv1.setRotate(0);
							if(timesPressed1!=0){
								rotateAmount1=360;
							}
							else{
								rotateAmount1=0;
							}
						}
						else if(r==1){
							iv1.setRotate(90);
							rotateAmount1=90;
						}
						else if(r==2){
							iv1.setRotate(180);
							rotateAmount1=180;
						}
						else if(r==3){
							iv1.setRotate(270);
							rotateAmount1=270;
						}
					});
					RadioButton rb1 = new RadioButton();
					rb1.setGraphic(iv1);
					rb1.setText("Select Tile 2");
					rb1.setToggleGroup(group);
					int data1 = 1;
					rb1.setUserData(data1);
					flow.getChildren().add(rb1);
					flow.getChildren().add(btn1);
				}
				if(numberOfTiles>2){
					Image tile2 = player.hand.get(2).image;
					ImageView iv2 = new ImageView(tile2);
					Button btn2 = new Button();
					btn2.setText("Click to Rotate");
					btn2.setOnAction((event)->{
						timesPressed2+=1;
						int r = timesPressed2%4;
						if(r==0){
							iv2.setRotate(0);
							if(timesPressed2!=0){
								rotateAmount2=360;
							}
							else{
								rotateAmount2=0;
							}
						}
						else if(r==1){
							iv2.setRotate(90);
							rotateAmount2=90;
						}
						else if(r==2){
							iv2.setRotate(180);
							rotateAmount2=180;
						}
						else if(r==3){
							iv2.setRotate(270);
							rotateAmount2=270;
						}
					});
					RadioButton rb2 = new RadioButton();
					rb2.setGraphic(iv2);
					rb2.setText("Select Tile 3");
					rb2.setToggleGroup(group);
					int data2 = 2;
					rb2.setUserData(data2);
					flow.getChildren().add(rb2);
					flow.getChildren().add(btn2);
				}
				Button btnPlayTile = new Button();
				btnPlayTile.setText("Play selected tile");
				btnPlayTile.setOnAction((event)->{
					int selectedNumber = (int)group.getSelectedToggle().getUserData();
					if(selectedNumber==0){
						placeTile(g, player.hand.get(0), rotateAmount0, player.row, player.column);
						player.hand.remove(0);
						drawCard(player);
						flow.getChildren().clear();
						root.setRight(addFlowPane(g, player));
					}
					else if (selectedNumber==1){
						placeTile(g, player.hand.get(1), rotateAmount1, player.row, player.column);
						player.hand.remove(1);
						drawCard(player);
						flow.getChildren().clear();
						root.setRight(addFlowPane(g, player));
					}
					else if(selectedNumber==2){
						placeTile(g, player.hand.get(2), rotateAmount2, player.row, player.column);
						player.hand.remove(2);
						drawCard(player);
						flow.getChildren().clear();
						root.setRight(addFlowPane(g, player));
					}
	    		
				});
				flow.getChildren().add(btnPlayTile);
			}
				return flow;
		}
		
		public void placeTile(GridPane grid, Tile tile, int row, int col) {
			ImageView tileView = new ImageView(tile.image);
			grid.add(tileView, col+1, row+1);
			board.get(row).set(col, tile);
			for(Figure f : figures) {
				if((f.row == row) && (f.column == col)) {
					f.move(board);
				}
			}
		}
		
		public void placeTile(GridPane grid, Tile tile, int rotate, int row, int col) {
			ImageView tileView = new ImageView(tile.image);
			tileView.setRotate(rotate);
			tile.changePairsToReflectRotate(rotate);
			System.out.println("row: "+row+"Col:"+col);
			grid.add(tileView, col+1, row+1);
			board.get(row).set(col, tile);
			for(Figure f : figures) {
				if((f.row == row) && (f.column == col)) {
					f.move(board);
				}
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	}
