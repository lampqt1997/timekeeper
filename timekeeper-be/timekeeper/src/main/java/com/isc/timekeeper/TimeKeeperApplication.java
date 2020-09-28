package com.isc.timekeeper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isc.timekeeper.multipledb.api.token.PasswordEncoder;
import com.isc.timekeeper.multipledb.biostar.service.BioStarDepartmentService;
import com.isc.timekeeper.multipledb.biostar.service.BioStarEvenLogBKService;
import com.isc.timekeeper.multipledb.biostar.service.BioStarEvenLogService;
import com.isc.timekeeper.multipledb.biostar.service.BioStarUserService;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEmployee;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEvenLog;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperPosition;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperUser;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperEmployeeService;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperEvenLogService;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperPositionService;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperShiftService;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperUserService;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { DataSourceTransactionManagerAutoConfiguration.class,
//		HibernateJpaAutoConfiguration.class })

public class TimeKeeperApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BioStarUserService seftService;
	@Autowired
	private BioStarEvenLogService bEvenLogService;
	@Autowired
	private BioStarEvenLogBKService bEvenLogBKService;
	
	@Autowired
	private TimeKeeperEvenLogService tkEvenLogService;
	
	@Autowired
	private BioStarDepartmentService bDepartmentService;
	@Autowired
	private TimeKeeperEmployeeService tkEmployeeService;
	@Autowired
	private TimeKeeperPositionService tkPositionService;
	
	@Autowired
	private TimeKeeperShiftService tkShiftService;
	
	@Autowired
	private TimeKeeperUserService tkKeeperUserService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(TimeKeeperApplication.class, args);
	}
	@PostConstruct
    void started() {
        // set JVM timezone as UTC
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
	@Override
	public void run(String... args) throws Exception {
		
//		Optional<TimeKeeperEmployee> employee = tkEmployeeService.getByCode("30075");
//		System.out.println(employee.get().getPosition());
//		System.out.println(employee.get().getDepartment());
		
		
//		TimeKeeperPosition po1 = new TimeKeeperPosition( "Công nhân", false);
//		TimeKeeperPosition po2= new TimeKeeperPosition( "Kế toán", false);
//		tkPositionService.addPosition(po1);
//		tkPositionService.addPosition(po2);
//		
//		TimeKeeperUser user = TimeKeeperUser.builder()
//				.email("lampqt1997@gmail.com")
//				.password(PasswordEncoder.builder().build().encode("123456789"))
//				.firstName("Lam")
//				.userName("admin")
//				.build();
//		
//		tkKeeperUserService.save(user);
//		
//		TimeKeeperUser u = tkKeeperUserService.getUserByUserName("admin");
//		String passEncode = PasswordEncoder.builder().build().encode("123456789");
//		System.out.println(passEncode);
//		System.out.println(passEncode.equals(u.getPassword()));
//				
		
//		List<TimeKeeperEvenLog> listEvents = (List<TimeKeeperEvenLog>)tkEvenLogService.getTimeKeeper(1, 50, LocalDate.of(2020, 8, 25));
//		for (TimeKeeperEvenLog timeKeeperEvenLog : listEvents) {
//			System.out.println(timeKeeperEvenLog.getEmployee().getEmployeeCode()+"-"+timeKeeperEvenLog.getCheckDate());
//		}
		
//		
		
//		Byte[] bs = {1,1,1,1,1,1,1};
//		
//		TimeKeeperShift shift = new TimeKeeperShift("CA1", "Ca 1", LocalTime.of(6, 0), LocalTime.of(14, 0),1, bs, false);
//		
//		tkShiftService.addShift(shift);
//		
		
		
		
		
		
		
		
		
		
//		List<UserDept> uds = deptService.getAll();
//		List<UserSeft> uss = seftService.getAll();
//		List<UserEvenLog> uels = evenLogService.getAll();
//		List<UserEvenLogBK> uelbks = evenLogBKService.getAll();
//		System.out.println(uds);
//		System.out.println(uss);
//		System.out.println(uels);
//		System.out.println(uelbks);
//		System.out.println(evenLogService.getFromIdToMax(949600));
//		List<BioStarEvenLog> bList = bEvenLogService.getFromIdToMax(0);
//		for (BioStarEvenLog bioStarUser : bList) {
//			Optional<TimeKeeperEmployee> t = tkEmployeeService.getById(bioStarUser.getNUserID());
//			if (t.isPresent()) {
//				System.out.println(t.get());	
//			}
//		}
//		List<Object[]> os = bEvenLogService.getAllCustomFromIdToMax(0);
//		for (Object[] v : os) {
//			System.out.println(v[0]);
////			for (Object objects : v) {
////				System.out.println(objects);
////			}
//		}
	}

}
