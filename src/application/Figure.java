package application;

import java.util.ArrayList;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;


public class Figure{
	public int row, column, port;
	public boolean alive;
	public ArrayList<Tile> hand;
	public ImageView image;



	public Figure(int player, Rectangle2D visualBounds, double spacePercent){
		row = -1;
		column = -1;
		port = -1;
		alive = true;
		hand = new ArrayList<Tile>();
		/*if(player==1) {
			Image jeff = new Image("JeffreyJaffe.jpg",Math.ceil((visualBounds.getWidth() / 2) * spacePercent), Math.ceil(visualBounds.getWidth() / 2 * spacePercent),false,false);
			image = new ImageView(jeff);
		}
		else {
			Image bernie = new Image("Berners-Lee.jpg",Math.ceil((visualBounds.getWidth() / 2) * spacePercent), Math.ceil(visualBounds.getWidth() / 2 * spacePercent),false,false);
			image = new ImageView(bernie);
		}
		*/
	}
	
	public void place(int r, int c, int p){
		row = r;
		column = c;
		port = p;
	}
	
	private void safe(){
		if(row < 0||row > 5){
			alive = false;
		}
		else if(column < 0||column > 5){
			alive = false;
		}
	}

	public void move(ArrayList<ArrayList<Tile>> board){
		Tile t = board.get(this.row).get(this.column);
		while(t.id != -1 && this.alive){
			if(t.pairs[port]%2 == 0){
				this.port = (t.pairs[port] + 5) % 8;
			}
			else{
				this.port = (t.pairs[port] + 3) % 8;
			}
			if(this.port <= 1){
				this.row++;
			}
			else if(this.port <= 3){
				this.column--;
			}
			else if(this.port <= 5){
				this.row--;
			}
			else {
				this.column++;
			}
			this.safe();
			if(this.alive){
				System.out.println("crossed tile safely");
				t = board.get(this.row).get(this.column);
			}
			else{
				System.out.println("crossed tile and died");
			}
			System.out.println(this);
		}

	}

	public String toString() {
		return Integer.toString(this.row)+" "+Integer.toString(this.column)+" "+Integer.toString(this.port);
	}

	public static void main(String[] args){
		/*Figure f = new Figure();
		Figure f2 = new Figure();
		int[] tempPairs1 = {2,5,0,7,6,1,4,3};
		Tile tile = new Tile(tempPairs1, 1);
		f.place(3,2,1);
		f2.place(0,0,1);
		f.move(tile);
		System.out.println("\n");
		System.out.println(f2);
		f2.move(tile);*/
	}
}