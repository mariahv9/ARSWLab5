package edu.eci.arsw.cinema.model;

import edu.eci.arsw.cinema.persistence.CinemaException;
import java.util.*;

/**
 *
 * @author cristian
 */
public class CinemaFunction {
    
    private Movie movie;
    private List<List<Boolean>> seats=new ArrayList<>();
    private String date;
    
    public CinemaFunction(){}
    
    public CinemaFunction(Movie movie, String date){
        this.movie=movie;
        this.date=date;
        for (int i=0;i<7;i++){
            List<Boolean> row= new ArrayList<>(Arrays.asList(new Boolean[12]));
            Collections.fill(row, Boolean.TRUE);
            this.seats.add(row);
        }
    }
    
    public void buyTicket(int row,int col) throws CinemaException{
        if (seats.get(row).get(col).equals(true)){
            seats.get(row).set(col,Boolean.FALSE);
        }
        else{
            throw new CinemaException("Seat booked");
        }
    }

    public int getSeatsState(Boolean state){
        int freeSeats = 0;
        for (List<Boolean> row : seats){

            for (Boolean seat : row){

                if (seat == state){
                    freeSeats ++;
                }
            }
        }
        return freeSeats;
    }

    public List<List<Boolean>> getSeats() {
        return this.seats;
    }
    
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}