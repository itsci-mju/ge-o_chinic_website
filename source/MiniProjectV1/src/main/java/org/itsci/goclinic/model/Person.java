package org.itsci.goclinic.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

@Entity
@Table( name = "person")
public class Person implements UserDetails {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@GenericGenerator(name = "increment", strategy = "increment")
	private int person_id;
	@Column(length = 100,nullable = false)
	private String full_name;
	@Column(length = 25,nullable = false)
	private String nickname;
	@Column(length = 45,nullable = false)
	private Date birthday;
	@Column(length = 45,nullable = false)
	private String id_card;
	@Column(length = 100,nullable = false)
	private String gender;
	@Column(length = 255,nullable = false)
	private String address;
	@Column(length = 10,nullable = false)
	private String phone_number;
	@Column(length = 50)
	private String congenital_disorder;
	@Column(length = 50)
	private String drug_allergy;
	@OneToMany(mappedBy="person")
	private List<BuyService> list_buyservice = new Vector<>();
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "logins_FK",referencedColumnName  = "email", unique = true)
	private Login login;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Authority> authorities = new HashSet<>();

	public Person() {}

	public Person(String full_name, String nickname, Date birthday, String id_card,
			String gender, String address, String phone_number, String congenital_disorder,
			String drug_allergy) {
		super();
		this.full_name = full_name;
		this.nickname = nickname;
		this.birthday = birthday;
		this.id_card = id_card;
		this.gender = gender;
		this.address = address;
		this.phone_number = phone_number;
		this.congenital_disorder = congenital_disorder;
		this.drug_allergy = drug_allergy;

	}

	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getCongenital_disorder() {
		return congenital_disorder;
	}
	public void setCongenital_disorder(String congenital_disorder) {
		this.congenital_disorder = congenital_disorder;
	}
	public String getDrug_allergy() {
		return drug_allergy;
	}
	public void setDrug_allergy(String drug_allergy) {
		this.drug_allergy = drug_allergy;
	}

	public List<BuyService> getList_buyservice() {
		return list_buyservice;
	}

	public void setList_buyservice(List<BuyService> list_buyservice) {
		this.list_buyservice = list_buyservice;
	}

	public Login getLogins() {
		return login;
	}

	public void setLogins(Login login) {
		this.login = login;
	}
	
	public Person(Login login) {
		this.login = login;
	}
	
//	public int getAge() {
//		Date birth;
//        Date sysdate;
//
//        LocalDate dob = LocalDate.parse(this.getBirthdayFormate());
//        LocalDate curDate = LocalDate.now(); 
//        if ((dob != null) && (curDate != null))
//        {
//            return Period.between(dob, curDate).getYears();
//        }else {
//            return 0;
//        }
		
//		birth = format.parse(format.format(birthday));
//        sysdate = format.parse(format.format(new Date()));
//        LocalDate currentDate = LocalDate.of(sysdate.getYear(), sysdate.getMonth(), sysdate.getDay());
//        LocalDate birthDate = LocalDate.of(birth.getYear(), birth.getMonth(), birth.getDay());
//        age =  Period.between(birthDate, currentDate).getYears();
//	}
	
	public String getBirthdayFormate() {
		SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy");
        Format.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(birthday);
        cal.add(Calendar.YEAR, 543);
        birthday = cal.getTime();
		return Format.format(birthday);
	}
	
	public String setBirthdayFormate() {
		SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        Format.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        System.out.println(Format.format(birthday));
		return Format.format(birthday);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return login.getPassword();
	}

	@Override
	public String getUsername() {
		return login.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
