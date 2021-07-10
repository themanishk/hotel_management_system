package com.demo2.demo2.controller;
import org.springframework.validation.BindingResult;
import com.demo2.demo2.repository.payinforepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo2.demo2.model.permission;
import com.demo2.demo2.model.position;
import com.demo2.demo2.model.booking;

import com.demo2.demo2.model.guest;
import com.demo2.demo2.model.log_in;
import com.demo2.demo2.model.payment;
import com.demo2.demo2.model.payment_info;
import com.demo2.demo2.model.room_info;
import com.demo2.demo2.model.rooms;
import com.demo2.demo2.model.test1;
import com.demo2.demo2.model.test2;
import com.demo2.demo2.model.user;

import com.demo2.demo2.repository.paymentrepo;
import com.demo2.demo2.repository.UserRepository;
import com.demo2.demo2.repository.permrepo;
import com.demo2.demo2.repository.roominforepo;
import com.demo2.demo2.repository.bookingrepo;
import com.demo2.demo2.repository.roomsrepo;

import com.demo2.demo2.repository.test1repo;
import com.demo2.demo2.repository.test2repo;

import com.demo2.demo2.repository.loginrepo;
import com.demo2.demo2.repository.positionrepo;
@Controller
public class controller {
	
	
	public booking book1=new booking();
	public guest guest1=new guest();
	
	public String roomtype;
	
	@Autowired
	test1repo repo1;
	
	@Autowired
	test2repo repo2;
	
	@Autowired
	positionrepo positionrepo;
	

	
	@Autowired
	UserRepository repo5;
	
	@Autowired
	roominforepo testrepo1;
	
	@Autowired
	roomsrepo testrepo2;
	
	@Autowired
	roominforepo roominforepo;
	
	@Autowired
	roomsrepo roomsrepo;
	@Autowired
	com.demo2.demo2.repository.guestrepo guestrepo;
	
	@Autowired
	bookingrepo bookingrepo;
	
	@Autowired
	paymentrepo paymentrepo;
	
	@Autowired
	com.demo2.demo2.repository.payinforepo payinforepo;
	

	
	@Autowired
	loginrepo loginrepo;
	
	
	

	
	
	
	@Autowired
     permrepo repo3;
	
	@RequestMapping("/")
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView();
		
		
		
		//System.out.print(room);
		mv.setViewName("index.html");
		return mv;}
	
	
	
	
	@RequestMapping(value="/booking" , method = RequestMethod.GET)
	public ModelAndView booking() {
		
		ModelAndView mv = new ModelAndView();
		booking book = new booking();
		
		guest guest = new guest();
		
		mv.addObject("book", book);
		List < room_info > roomsinfo =roominforepo.findAll();
		mv.addObject("guest", guest);
		mv.addObject("roomsinfo", roomsinfo);
		//mv.addObject("name","manish");
		mv.setViewName("booking.html");
		System.out.print(book);
		return mv;}
	
	

	
	@RequestMapping(value="/deleteroom" , method = RequestMethod.GET)
	public ModelAndView deleteroom() {
		//rooms delroom = roomsrepo.getOne(id);
		//roomsrepo.delete(delroom);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deleteroom.html");
		//System.out.print(book);
		int roomno=0;
		mv.addObject("roomno", roomno);
		
		
		return mv;
		
	}
	
	@RequestMapping(value="/deleteroomsuccess" )
	public ModelAndView deleteroomsuccess(@RequestParam int roomno) {
		
		ModelAndView mv = new ModelAndView();
		rooms room = roomsrepo.findByRoomno(roomno);
		rooms delroom = roomsrepo.getOne(room.getId());
		
		roomsrepo.delete(delroom);
		
		mv.setViewName("index.html");
		//System.out.print(book);
		return mv;
		
	}
	
	@RequestMapping(value="/updateroominfo" , method = RequestMethod.GET)
	public ModelAndView updateroominfo() {
		//rooms delroom = roomsrepo.getOne(id);
		//roomsrepo.delete(delroom);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateroominfo.html");
		//System.out.print(book);
		
		List < room_info > roomsinfo =roominforepo.findAll();

		room_info rooms = new room_info();
		mv.addObject("rooms", rooms);
		mv.addObject("roomsinfo", roomsinfo);
		
		
		
		return mv;
		
	}
	
	@RequestMapping(value="/updateroominfosuccess" , method = RequestMethod.POST)
	public ModelAndView updateroominfosuccess(@RequestParam String cate, room_info rooms) {
		
		ModelAndView mv = new ModelAndView();
		room_info roominfo = roominforepo.findByRoomname(cate);
		
		rooms.setBed(2);
		rooms.setId(roominfo.getId());
		rooms.setRoomname(cate);
		roominforepo.save(rooms);
		
		
		
		mv.setViewName("index.html");
		//System.out.print(book);
		return mv;
		
	}
	
	@RequestMapping(value="/updateroom" , method = RequestMethod.GET)
	public ModelAndView updateroom() {
		//rooms delroom = roomsrepo.getOne(id);
		//roomsrepo.delete(delroom);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateroom.html");
		//System.out.print(book);
		int roomno=0;
		mv.addObject("roomno", roomno);
		
		
		return mv;
		
	}
	
	@RequestMapping(value="/updateroomsuccess" )
	public ModelAndView updateroomsuccess(@RequestParam int roomno) {
		
		ModelAndView mv = new ModelAndView();
		rooms room = roomsrepo.findByRoomno(roomno);
		rooms delroom = roomsrepo.getOne(room.getId());
		
		roomsrepo.save(delroom);
		
		mv.setViewName("index.html");
		//System.out.print(book);
		return mv;
		
	}
	
 
	
	@RequestMapping(value="/addroom" , method = RequestMethod.GET)
	public ModelAndView addroom() {
		
		ModelAndView mv = new ModelAndView();
		rooms room = new rooms();
		room_info roominfo = new room_info();
		
		
		mv.addObject("room", room);
		mv.addObject("roominfo", roominfo );
		String cate=new String();
		mv.addObject("cate", cate );
		//mv.addObject("guest", guest);
		//mv.addObject("name","manish");
		mv.setViewName("addroom.html");
		//System.out.print(book);
		return mv;}
	
	@RequestMapping(value="/addroomsuccess" , method = RequestMethod.POST)
	public ModelAndView addroomsuccess(room_info roominfo,rooms room, @RequestParam String cate) {
		
		ModelAndView mv = new ModelAndView();
		room_info ri = roominforepo.findByRoomname(cate);
		System.out.print(room);
		System.out.print("manish..");
		System.out.print(cate);
		System.out.print("..manish...");
		
	
		room.setRoominfo(ri);
		roomsrepo.save(room);
		
		
		
		
		
		
		//mv.addObject("guest", guest);
		//mv.addObject("name","manish");
		mv.setViewName("index.html");
		//System.out.print(book);
		return mv;}
	
	@RequestMapping(value="/rooms" , method = RequestMethod.GET)
	public ModelAndView rooms() {
		
		ModelAndView mv = new ModelAndView();
		rooms room = new rooms();
		room_info roominfo = new room_info();
		List < room_info > rooms =roominforepo.findAll();
		
		
		
		mv.addObject("rooms", rooms );
		String cate=new String();
		mv.addObject("cate", cate );
		
		
		
		mv.setViewName("rooms.html");
		//System.out.print(book);
		return mv;}
	
	
	
	@RequestMapping(value="/bookingsuccess" , method = RequestMethod.POST)
	public ModelAndView success(booking book, guest guest,payment payment , payment_info payinfo,Principal principal) {
		
		ModelAndView mv = new ModelAndView();

		
		System.out.print("manish loading.............");
		

		
		String username  = principal.getName();
		log_in loginuser = new log_in();
		loginuser = loginrepo.findByUsername(username);
		
		
		user user = loginuser.getUser();
		//user user = repo5.findById(101);
		book1.setUser(user);
		
		
		
		
		
		room_info ri = roominforepo.findByRoomname(roomtype);
		
		List<rooms> room = roomsrepo.findByRoominfo(ri);
		
		
		System.out.print(payment);
		
		paymentrepo.save(payment);
		payinfo.setPayment(payment);
		payinforepo.save(payinfo);
		
		rooms roomtest = new rooms();
		roomtest = room.get(0);
		
		
		book1.setRoom(room.get(0));
		//System.out.print(book);
		
		
		
	
		
		book1.setPayment(payment);
		System.out.print("vinod loading.............");

		
		
		booking book2 = bookingrepo.save(book1);
		
		guest1.setBooking(book2);
		guestrepo.save(guest1);
		
		
		//mv.addObject("guest", guest);
		mv.addObject("book2", book2);
		mv.addObject("payment", payment);
		mv.addObject("payinfo", payinfo);
		mv.addObject("guest", guest1);
		mv.addObject("user", user);
		
		mv.setViewName("invoice.html");
		//System.out.print(book);
		return mv;}
	

	

	
	@RequestMapping(value="/guestinfo", method = RequestMethod.POST)
	public ModelAndView guestinfoinfo(booking book, guest guest, @RequestParam String cate) {
		
		ModelAndView mv = new ModelAndView();
		//email.setEmail("asdfghjk");
		//System.out.print(book);
		//System.out.print(email);
		System.out.print(book);
		guest1.setGuestname(guest.getGuestname());

		roomtype = cate;

	  
		
		mv.addObject("book", book);
		
		mv.addObject("guest", guest);
		book1.setBookdate(book.getBookdate());
		book1.setDepdate(book.getDepdate());
		book1.setPhone(book.getPhone());
		book1.setTotalguest(book.getTotalguest());
		guest1.setGuestname(guest.getGuestname());
		
		
		
		
		//mv.addObject("name","manish");
		mv.setViewName("guestinfo.html");
		System.out.print(book);
		return mv;}
	
	@RequestMapping(value="/payment", method = RequestMethod.POST)
	public ModelAndView payment(booking book,guest guest) {
		
		ModelAndView mv = new ModelAndView();
		//System.out.print(book);
		 
		
		
		payment payment = new payment();
		

		

		
		payment_info payinfo = new payment_info();
		book1.setEmail(book.getEmail());
		guest1.setAadhar(guest.getAadhar());
		guest1.setAge(guest.getAge());
		book1.setAddress(book.getAddress());
		
		mv.addObject("book", book);
		mv.addObject("payment", payment);
		mv.addObject("payinfo", payinfo);
		mv.addObject("guest", guest1);
		
		System.out.print(book);
		
		//mv.addObject("name","manish");
		mv.setViewName("payment.html");
		return mv;} 
	
	
	@RequestMapping("/addroom1")
	public ModelAndView addroom1() {
		
		ModelAndView mv = new ModelAndView();
		/*room_info info = new room_info();
		info.setBed(2);
		info.setAc(true);
		info.setPrice(2200);
		info.setRoomname("lux2");
		info.setTv(true);
		System.out.print(info);*/
		
		booking book = new booking();
		book.setBookdate("2020-11-10");
		book.setDepdate("2020-11-13");
		book.setPhone("99898989898");
		book.setTotalguest(3);
		user user = repo5.findById(101);
		book.setUser(user);
		
		room_info ri = roominforepo.findByRoomname("luxury");
		
		rooms room = roomsrepo.findByRoominfo(ri);
		
		book.setRoom(room);
		
		payment pay = new payment();
		pay.setAmount(3000);
		pay.setDate("2020-11-11");
		pay.setPaydesc("throuh sbi");
		
		paymentrepo.save(pay);
		
		System.out.print("proalkfsjdfhoshiudhbs is rinnunf akjnsd");
		
		book.setPayment(pay);
		bookingrepo.save(book);
		

		 

		
		
		
		//mv.addObject("name","manish");
		mv.setViewName("index.html");
		return mv;}
	

	

		
		
		@RequestMapping(value="/register", method = RequestMethod.GET)
		public ModelAndView register() {
			ModelAndView modelAndView = new ModelAndView();
			
			user emp = new user();
			position position = new position();
			
			
			log_in user = new log_in();
			//log_in log_in = new log_in();
			modelAndView.addObject("emp", emp);
			modelAndView.addObject("position", position);
			modelAndView.addObject("user", user);

			//modelAndView.addObject("log_in", log_in);
			System.out.print("manisg regar is ljadnf");
		
			
			
			modelAndView.setViewName("register.html"); // resources/template/register.html
			return modelAndView;
		}
		
		
		@RequestMapping(value="/register", method = RequestMethod.POST)
		public ModelAndView registerUser(@Valid user emp, BindingResult bindingResult,@Valid  log_in user ,BindingResult result, Model modelMap, @RequestParam String cate) {
			ModelAndView modelAndView = new ModelAndView();
			System.out.print(bindingResult);
			//user.setPosname(cate);
			
			if(bindingResult.hasErrors() || result.hasErrors()) {
				
				modelAndView.addObject("successMessage", "Please correct the errors in form!");
				modelMap.addAttribute("bindingResult", bindingResult);
				modelMap.addAttribute("result", result);
				
				modelAndView.addObject("emp", new user());
				modelAndView.addObject("user", new log_in());
				modelAndView.setViewName("register.html");
				
				return modelAndView;
				
			}
			
			String pass= user.getPassword();
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(pass);
			user.setPassword(hashedPassword);
			
			position position = positionrepo.findByPosname(cate);
			user.setPosition(position);
			repo5.save(emp);
			System.out.print(user);
			user.setUser(emp);
			//user.setPosname(cate);
			System.out.print(user);
			
			loginrepo.save(user);
			
			
			
	
		
			
			modelAndView.setViewName("index.html");
			
			
			return modelAndView;
		}
		
		
		
		@RequestMapping(value="/previousbooking" , method = RequestMethod.GET)
		public ModelAndView previousbooking() {
			
			ModelAndView mv = new ModelAndView();
			
			
			room_info roominfo = new room_info();
			List < booking > book =bookingrepo.findAll();
			
			
			
			mv.addObject("book", book );
			String cate=new String();
			mv.addObject("cate", cate );
		
			
			
			
	
			mv.setViewName("previousbooking.html");
			//System.out.print(book);
			return mv;}
		
		@RequestMapping(value="/bookinginfo/{id}" , method = RequestMethod.GET)
		public ModelAndView bookinginfo(@PathVariable int id) {
			
			ModelAndView mv = new ModelAndView();
			
			
			room_info roominfo = new room_info();
			
			
			booking book =bookingrepo.findById(id);
			payment payment = book.getPayment();
			payment_info paymentinfo = payinforepo.findByPayment(payment);
			guest guest = guestrepo.findBybooking(book);
			
			System.out.print(book);
			
			mv.addObject("book2", book );
			mv.addObject("guest", guest );
			mv.addObject("payinfo", paymentinfo );
			mv.addObject("payment", payment );
			String cate=new String();
			mv.addObject("cate", cate );

			
			
			
	
			mv.setViewName("invoice.html");
		
			return mv;}
		
		
		
		

		@RequestMapping(value = { "/signin" }, method = RequestMethod.GET)
		public ModelAndView login() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("login.html"); // resources/template/login.html
			return modelAndView;
		}
		
		
		
		
		

		
		
}
