/**
 * 
 *//*
package dataProvider;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Userinfo;
import dataProvider.ConfigFileReader;
*//**
 * @author sanpatnaik
 *
 *//*
public class JsonDataReader {
	private final String userFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Userinfo.json";
	private List<Userinfo> userdetails;
	
	public JsonDataReader(){
		userdetails = getUserData();
	}
	
	private List<Userinfo> getUserData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(userFilePath));
			Userinfo[] customers = gson.fromJson(bufferReader, Userinfo[].class);
			return Arrays.asList(customers);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + userFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	public final Userinfo getUserByName(String userName){
			 return userdetails.stream().filter(x -> x.getFirstname().equalsIgnoreCase(userName)).findAny().get();
	}
	public final Customer getCustomerByName(String customerName){
		for(Customer customer : customerList) {
			if(customer.firstName.equalsIgnoreCase(customerName)) return customer;
		}
		return null;
	}
 
}
*/