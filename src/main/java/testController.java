//import java.io.File;
//import java.io.IOException;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.ssm.ashrayanepal.controller.HostController;
//import com.ssm.ashrayanepal.model.HostDetails;
//import com.ssm.ashrayanepal.repository.HostRepository;
//import com.ssm.ashrayanepal.service.HostService;
//
//@Controller
//@RequestMapping(value = "/")
//public class testController {
//
//	private final static Logger log = LoggerFactory.getLogger(HostController.class);
//
//	@Autowired
//	HostRepository repository;
//	@Autowired
//	HostService hostService;
//	/*
//	 * @Autowired HttpServlet request;
//	 */
//
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String hostDetail(HttpServletRequest request, HttpServletResponse response, ModelMap model)
//			throws ServletException, IOException {
//		model.addAttribute("hostDetail", new HostDetails());
//		return "test";
//	}
//
//	@RequestMapping(value = "/test", method = RequestMethod.POST)
//
//	public String hostDetail(@RequestParam("file") MultipartFile photo, HttpServletRequest httpRequest,
//			HttpServletResponse response, HostDetails hostDetail, ModelMap model,
//			final RedirectAttributes redirectAttributes) throws ServletException, IOException {
//		System.out.println("here");
//		if (!photo.isEmpty()) {
//			try {
//				String uploadsDir = "/upload/";
//				String realPathtoUploads = ((ServletConfig) httpRequest).getServletContext().getRealPath(uploadsDir);
//				if (!new File(realPathtoUploads).exists())
//					;
//				{
//					new File(realPathtoUploads).mkdir();
//
//				}
//				log.info("realPathtoUploads={}", realPathtoUploads);
//				String orgName = photo.getOriginalFilename();
//				String filePath = realPathtoUploads + orgName;
//				File dest = new File(filePath);
//				photo.transferTo(dest);
//			} finally {
//
//				hostService.save(hostDetail);
//
//			}
//		}
//		return "redirect:/welcome";
//	}
//}