package main;

import pieces.Knight;
import pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    public int tileSize = 85;
    int cols = 8;
    int rows = 8;
    ArrayList<Piece> pieceList = new ArrayList<>();

    public Board(){
        this.setPreferredSize(new Dimension(cols*tileSize,rows * tileSize));
    }
    public void addPieces() {
        pieceList.add(new Knight(this,2,0,false));
    }
    public void paintComponent (Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        for(int r = 0; r<rows; r++)
            for(int c = 0; c<cols; c++){
                g2d.setColor((c+r)%2 == 0 ? new Color(166, 218, 97): new Color(88, 81, 6));
                g2d.fillRect(c*tileSize, r*tileSize,tileSize,tileSize );

            }
        for(Piece piece : pieceList){
            piece.paint(g2d);
        }
    }
}
