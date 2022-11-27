package entities;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Seller implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String email;
	@NonNull
	private Date birthDate;
	@NonNull
	private Double baseSalary;
	private Department department;
}