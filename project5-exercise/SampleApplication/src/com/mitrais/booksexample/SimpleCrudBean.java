package com.mitrais.booksexample;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SimpleCrudBean implements Serializable {
	private static final long serialVersionID= 1L;
	
	private List<Books> list;
	private Books book=new Books();
	private Books beforeEditBook = null;
	public boolean edit;
	public boolean status;
	public boolean statusTitle;
	public boolean statusPrice;
	
	@PostConstruct
	public void init(){
		list=new ArrayList<Books>();
	}
	
	public void add(){
		status=false;
		statusTitle=false;
		statusPrice=false;
		
		if(book.getIsbn().equals("")==true)
		{
			status=true;
		} else if (book.getTitle().equals("")==true)
		{
			statusTitle=true;;
		}
		else if (book.getPrice().equals("")==true)
		{
			statusPrice=true;
		}
		else
		{
			book.setId(list.isEmpty()? 1:list.get(list.size()-1).getId()+1);
			list.add(book);
			book=new Books();
			status=false;
			statusTitle=false;
			statusPrice=false;
		}
		
		
	}
	
	public void resetAdd(){
		book= new Books();
		status=false;
		statusTitle=false;
		statusPrice=false;
	}
	
	public void edit(Books book){
		beforeEditBook= book.clone();
		this.book=book;
		edit=true;
	}
	
	public void cancelEdit(){
		this.book.restore(beforeEditBook);
		this.book=new Books();
		edit=false;
		status=false;
		statusTitle=false;
		statusPrice=false;
	}
	
	public void saveEdit(){
		status=false;
		statusTitle=false;
		statusPrice=false;
		
		if(book.getIsbn().equals("")==true)
		{
		   status=true;
		} else if (book.getTitle().equals("")==true)
		{
			statusTitle=true;;
		}
		else if (book.getPrice().equals("")==true)
		{
			statusPrice=true;
		}
		else
		{
			this.book=new Books();
			edit=false;
			status=false;
			statusTitle=false;
			statusPrice=false;
			
		}
		
		
	}
	
	public void delete(Books book) throws IOException{
		list.remove(book);
	}
	
	public List<Books> getList(){
		return list;
	}
	
	public Books getBook(){
		return this.book;
	}
	
	public boolean isStatus(){
		return this.status;
	}
	
	public boolean isStatusTitle(){
		return this.statusTitle;
	}
	
	public boolean isStatusPrice(){
		return this.statusPrice;
	}
	
	public boolean isEdit(){
		return this.edit;
	}
}
