package org.main.java;
import java.io.File;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip_folder{

	List <String> fileList = new ArrayList<String>();

	/* OUTWARD IN_PUT_FOLDER_PATH*/
	private static String IN_PUT_OUTWARD_PAIN009= "/home/user/eclipse-workspace/DemoMand/chetan/OUTWARD_FOLDER/MMS-CREATE-INDB-INDBH2H-26032021-000110-INP ";
	private static String IN_PUT_OUTWARD_ACK="/home/user/eclipse-workspace/DemoMand/chetan/OUTWARD_FOLDER/MMS-CREATE-INDB-INDBH2H-06052020-000005-INP-ACK";

	/* INWARD IN_PUT_FOLDER_PATH*/
	private static String IN_PUT_INWARD_PAIN009="/home/user/eclipse-workspace/DemoMand/chetan/INWARD_FOLDER/MMS-CREATE-INDB-INDBH2H-10042021-208115-INW";

	/* PAYMENT ACH_FOLDER_PATH*/
	private static String IN_PUT_INP="/home/user/eclipse-workspace/DemoMand/chetan/PAYMENT/INP_FOLDER";
	private static String IN_PUT_ACK="/home/user/eclipse-workspace/DemoMand/chetan/PAYMENT/ACK_FOLDER";
	private static String IN_PUT_RES="/home/user/eclipse-workspace/DemoMand/chetan/PAYMENT/RES_FOLDER";
	private static String IN_PUT_DONE="/home/user/eclipse-workspace/DemoMand/chetan/PAYMENT/RES.DONE";
	private static String IN_PUT_SIGNED="/home/user/eclipse-workspace/DemoMand/chetan/PAYMENT/SIGNED";
	private static String IN_PUT_UNSIGNED="/home/user/eclipse-workspace/DemoMand/chetan/PAYMENT/UNSIGNED";
	private static String IN_PUT_ENCRYPT="/home/user/eclipse-workspace/DemoMand/chetan/PAYMENT/ENCRYPT";

	public static void main( String[] args ){

		Random random=new Random();

		Scanner sc= new Scanner(System.in);

		System.out.println("Enter File_Type-(Mandate/payment)");
		String file_type=sc.next();

		if(file_type.equalsIgnoreCase("Mandate")) {
			System.out.println("Enter Mandate Upload Mode Type-(outward/inward)");
			String mode_type=sc.next();

			if(mode_type.equalsIgnoreCase("outward")) {
				System.out.println("Enter Folder Type-pain009/ack");
				String folder_type=sc.next();

				/*1*/		if(folder_type.equalsIgnoreCase("Pain009")) {
					System.out.println("Enter the file type:(Zip/ZipDone)");
					String file_type_mode=sc.next();
					if(file_type_mode.equalsIgnoreCase("zip")) {		
						System.out.println("Enter the count for unsigned zip");
						int count=sc.nextInt();
						String OUT_PUT_PAIN009="";

						for(int i=1;i<=count;i++) {
							String  random_value = random.nextInt(800000)+"-INP";
							OUT_PUT_PAIN009 = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/OUTWARD/pain009/MMS-CREATE-INDB-INDBH2H-10042021-"+random_value+".zip";
							Zip_folder appZip = new Zip_folder();
							appZip.generateFileList_PAIN009(new File(IN_PUT_OUTWARD_PAIN009));
							appZip.zipIt_Pain009(OUT_PUT_PAIN009);
						}}
					else if(file_type_mode.equalsIgnoreCase("zipDone")) {		
						System.out.println("Enter the count for unsigned zip.done");
						int count=sc.nextInt();
						String OUT_PUT_PAIN009="";

						for(int i=1;i<=count;i++) {
							String  random_value = random.nextInt(800000)+"-INP.zip";
							OUT_PUT_PAIN009 = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/OUTWARD/pain009/MMS-CREATE-INDB-INDBH2H-10042021-"+random_value+".done";
							Zip_folder appZip = new Zip_folder();
							appZip.generateFileList_PAIN009(new File(IN_PUT_OUTWARD_PAIN009));
							appZip.zipIt_Pain009(OUT_PUT_PAIN009);
						}}
				}else if(folder_type.equalsIgnoreCase("Ack")) {
					System.out.println("Enter the count");
					int count=sc.nextInt();
					String OUT_PUT_ACK="";
					for(int i=1;i<=count;i++) {
						String  random_value = random.nextInt(1000000)+"-INP-ACK";
						OUT_PUT_ACK = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/OUTWARD/ACK/MMS-CREATE-INDB-INDBH2H-06052020-"+random_value+".zip";
						Zip_folder appZip = new Zip_folder();
						appZip.generateFileList_ACK(new File(IN_PUT_OUTWARD_ACK));
						appZip.zipIt_ACK(OUT_PUT_ACK);
					} 	    
				}
			}else if(mode_type.equalsIgnoreCase("inward")) {

				System.out.println("Enter the file type:(Zip/ZipDone)");
				String file_type_mode=sc.next();
				if(file_type_mode.equalsIgnoreCase("zip")) {	
					System.out.println("Enter the count for pain009 unsigned zip");
					int count=sc.nextInt();
					String INWARD_OUT_PUT_PAIN009="";
					for(int i=1;i<=count;i++) {
						String  random_value = random.nextInt(1000000)+"-INW";
						INWARD_OUT_PUT_PAIN009 = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/INWARD/pain009/MMS-CREATE-INDB-INDBH2H-10042021-"+random_value+".zip";
						Zip_folder appZip = new Zip_folder();
						appZip.generateFileList_INWARD_PAIN009(new File(IN_PUT_INWARD_PAIN009));
						appZip.zipIt_INWARD_PAIN009(INWARD_OUT_PUT_PAIN009);
					}
				}
				else if(file_type_mode.equalsIgnoreCase("zipDone")) {	
					System.out.println("Enter the count for pain009 unsigned zip.done");
					int count=sc.nextInt();
					String INWARD_OUT_PUT_PAIN009="";
					for(int i=1;i<=count;i++) {
						String  random_value = random.nextInt(1000000)+"-INW.zip";
						INWARD_OUT_PUT_PAIN009 = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/INWARD/pain009/MMS-CREATE-INDB-INDBH2H-10042021-"+random_value+".done";
						Zip_folder appZip = new Zip_folder();
						appZip.generateFileList_INWARD_PAIN009(new File(IN_PUT_INWARD_PAIN009));
						appZip.zipIt_INWARD_PAIN009(INWARD_OUT_PUT_PAIN009);
					}
				}

			}
		}
		
		//---------------------------------------------------- PAYMENTS THINGS  -------------------------------------------------------
		
		else if(file_type.equalsIgnoreCase("payment")) {
			System.out.println("Enter Payment Mode-(flux/non-flux)");
			String payment_mode=sc.next();

		//--------------------------------------- payments flux -----------------------------------------------------------------------
			
			/*2*/	if(payment_mode.equalsIgnoreCase("Flux")) {
				System.out.println("Enter Payment Mode Extension(INP,ACK,RES,DONE,ENCRYPT)");
				String payment_extension=sc.next();

				if(payment_extension.equalsIgnoreCase("INP")) {
					System.out.println("Enter the count");
					int count=sc.nextInt();
					String PAYMENT_OUT_PUT_INP="";
					for(int i=1;i<=count;i++) {
						String  random_value = random.nextInt(1000000)+"-INP";
						PAYMENT_OUT_PUT_INP = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/PAYMENT/Flux/INP/ACH-DR-INDB-INDBH2H-07042021-"+random_value+".txt";
						Zip_folder appZip = new Zip_folder();
						appZip.generateFileList_PAYMENT_FLUX_ACH(new File(IN_PUT_INP));
						appZip.TXT_PAYMENT_FLUX_ACH(PAYMENT_OUT_PUT_INP);
					}

				}else if(payment_extension.equalsIgnoreCase("ACK")) {

					System.out.println("Enter the count");
					int count=sc.nextInt();
					String PAYMENT_OUT_PUT_ACK="";
					for(int i=1;i<=count;i++) {
						String  random_value = random.nextInt(1000000)+"-ACK";
						PAYMENT_OUT_PUT_ACK = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/PAYMENT/Flux/ACK/ACH-DR-INDB-INDBH2H-16022021-"+random_value+".xml";
						Zip_folder appZip = new Zip_folder();
						appZip.generateFileList_PAYMENT_FLUX_ACK(new File(IN_PUT_ACK));
						appZip.XML_PAYMENT_FLUX_ACK(PAYMENT_OUT_PUT_ACK);
					}

				}else if(payment_extension.equalsIgnoreCase("ENCRYPT")) {
					System.out.println("Enter the count");
					int count=sc.nextInt();
					String OUT_PUT_ENCRYPT="";
					for(int i=1;i<=count;i++) {
						String  random_value = random.nextInt(1000000)+"-RES";
						OUT_PUT_ENCRYPT = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/PAYMENTS/RES/MMS-CREATE-INDB-INDBH2H-06052020-"+random_value+".zip";
						Zip_folder appZip = new Zip_folder();
						appZip.generateFileList_ENCRYPT(new File(IN_PUT_ENCRYPT));
						appZip.zipIt_ENCRYPT(OUT_PUT_ENCRYPT);
					} 	    
				}
				else if(payment_extension.equalsIgnoreCase("RES")) {
					System.out.println("Enter the file type:(signed/unsigned)");
					String file_type_mode=sc.next();
					if(file_type_mode.equalsIgnoreCase("signed")) {
						System.out.println("Enter the count");
						int count=sc.nextInt();
						String PAYMENT_OUT_PUT_RES="";
						for(int i=1;i<=count;i++) {
							String  random_value = random.nextInt(1000000)+"-RTN";
							PAYMENT_OUT_PUT_RES = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/PAYMENT/Flux/RES/signed/ACH-DR-INDB-INDBH2H-08022021-"+random_value+".txt";
							Zip_folder appZip = new Zip_folder();
							appZip.generateFileList_PAYMENT_SIGNED(new File(IN_PUT_SIGNED));
							appZip.TXT_PAYMENT_SIGNED(PAYMENT_OUT_PUT_RES);
						}
					}
					else if(file_type_mode.equalsIgnoreCase("Unsigned")) {

						System.out.println("Enter the count");
						int count=sc.nextInt();
						String PAYMENT_OUT_PUT_RES="";
						for(int i=1;i<=count;i++) {
							String  random_value = random.nextInt(1000000)+"-RTN";
							PAYMENT_OUT_PUT_RES = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/PAYMENT/Flux/RES/unsigned/ACH-DR-INDB-INDBH2H-08022021-"+random_value+".txt";
							Zip_folder appZip = new Zip_folder();
							appZip.generateFileList_PAYMENT_UNSIGNED(new File(IN_PUT_UNSIGNED));
							appZip.TXT_PAYMENT_UNSIGNED(PAYMENT_OUT_PUT_RES);
						}
					}
				}
				else if(payment_extension.equalsIgnoreCase("DONE")) {

					System.out.println("Enter the count");
					int count=sc.nextInt();
					String PAYMENT_OUT_PUT_DONE="";
					for(int i=1;i<=count;i++) {
						String  random_value = random.nextInt(1000000)+"-RES.txt";
						PAYMENT_OUT_PUT_DONE = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/PAYMENT/Flux/DONE/ACH-DR-INDB-INDBH2H-16022021-"+random_value+".done";
						Zip_folder appZip = new Zip_folder();
						appZip.generateFileList_PAYMENT_FLUX_DONE(new File(IN_PUT_DONE));
						appZip.TXT_PAYMENT_FLUX_DONE(PAYMENT_OUT_PUT_DONE);
					}

				}
			}
			
			// ------------------------------------------------- payments non flux ---------------------------------------------------------\
			
			else if(payment_mode.equalsIgnoreCase("Non-flux")){
				System.out.println("Enter Payment Mode Extension(RES,DONE,ENCRYPT)");
				String payment_extension=sc.next();
				if(payment_extension.equalsIgnoreCase("RES")) {
					System.out.println("Enter the file type:(signed/unsigned)");
					String file_type_mode=sc.next();
					if(file_type_mode.equalsIgnoreCase("signed")) {
						System.out.println("Enter the count");
						int count=sc.nextInt();
						String PAYMENT_OUT_PUT_RES="";
						for(int i=1;i<=count;i++) {
							String  random_value = random.nextInt(1000000)+"-RTN";
							PAYMENT_OUT_PUT_RES = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/PAYMENT/Non-flux/RES/Signed/ACH-DR-INDB-INDBIBL-16022021-"+random_value+".txt";
							Zip_folder appZip = new Zip_folder();
							appZip.generateFileList_PAYMENT_SIGNED(new File(IN_PUT_SIGNED));
							appZip.TXT_PAYMENT_SIGNED(PAYMENT_OUT_PUT_RES);
						}
					}
					else if(file_type_mode.equalsIgnoreCase("Unsigned")) {

						System.out.println("Enter the count");
						int count=sc.nextInt();
						String PAYMENT_OUT_PUT_RES="";
						for(int i=1;i<=count;i++) {
							String  random_value = random.nextInt(1000000)+"-RTN";
							PAYMENT_OUT_PUT_RES = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/PAYMENT/Non-flux/RES/Unsigned/ACH-DR-INDB-INDBIBL-16022021-"+random_value+".txt";
							Zip_folder appZip = new Zip_folder();
							appZip.generateFileList_PAYMENT_UNSIGNED(new File(IN_PUT_UNSIGNED));
							appZip.TXT_PAYMENT_UNSIGNED(PAYMENT_OUT_PUT_RES);
						}
					}
				}
				else if(payment_extension.equalsIgnoreCase("DONE")) {

					System.out.println("Enter the count");
					int count=sc.nextInt();
					String PAYMENT_OUT_PUT_DONE="";
					for(int i=1;i<=count;i++) {
						String  random_value = random.nextInt(1000000)+"-RES.txt";
						PAYMENT_OUT_PUT_DONE = "/home/user/eclipse-workspace/DemoMand/chetan/ibl/PAYMENT/Non-flux/DONE/ACH-DR-INDB-INDBIBL-16022021-"+random_value+".done";
						Zip_folder appZip = new Zip_folder();
						appZip.generateFileList_PAYMENT_NON_FLUX_DONE(new File(IN_PUT_DONE));
						appZip.TXT_PAYMENT_NON_FLUX_DONE(PAYMENT_OUT_PUT_DONE);
					}

				}

			}
		}
	}	

	/**
	 * Zip it
	 * @param zipFile output ZIP file location
	 */
// --------------------------------- zip generation for pain009 ------------------------------------------------
	
	public void zipIt_Pain009(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);
			System.out.println("Pain009 : " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				ZipEntry ze= new ZipEntry(file);
				zos.putNextEntry(ze);
				FileInputStream in =
						new FileInputStream(IN_PUT_OUTWARD_PAIN009 + File.separator + file);
				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				in.close();
			}
			zos.closeEntry();
			zos.close();
			System.out.println("OUTWARD_PAIN009_ZIP_DONE");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public void generateFileList_PAIN009(File node){
		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_PAIN009(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_PAIN009(new File(node, filename));
			}
		}
	}
	private String generateZipEntry_PAIN009(String file){
		return file.substring(IN_PUT_OUTWARD_PAIN009.length()+1, file.length());
	}
	
	//------------------------------------------ payments encryption zip generation ---------------------------------------------
	
	public void zipIt_ENCRYPT(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);
			System.out.println("Encrypted : " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				ZipEntry ze= new ZipEntry(file);
				zos.putNextEntry(ze);
				FileInputStream in =
						new FileInputStream(IN_PUT_ENCRYPT + File.separator + file);
				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				in.close();
			}
			zos.closeEntry();
			zos.close();
			System.out.println("ENCRYPTED_ZIP_FILES");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public void generateFileList_ENCRYPT(File node){
		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_ENCRYPT(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_ENCRYPT(new File(node, filename));
			}
		}
	}
	private String generateZipEntry_ENCRYPT(String file){
		return file.substring(IN_PUT_ENCRYPT.length()+1, file.length());
	}
	/**
	 * Format the file path for zip
	 * @param file file path
	 * @return Formatted file path
	 */

	/**
	 * Zip it
	 * @param zipFile output ZIP file location
	 */
	// --------------------------------- zip file generation for the ack --------------------------------------------------
	
	public void zipIt_ACK(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);
			System.out.println("Ack : " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				ZipEntry ze= new ZipEntry(file);
				zos.putNextEntry(ze);
				FileInputStream in =
						new FileInputStream(IN_PUT_OUTWARD_ACK + File.separator + file);
				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				in.close();
			}
			zos.closeEntry();
			zos.close();
			System.out.println("OUTWARD_ACK_ZIP_DONE");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public void generateFileList_ACK(File node){
		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_ACK(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_ACK(new File(node, filename));
			}
		}
	}
	/**
	 * Format the file path for zip
	 * @param file file path
	 * @return Formatted file path
	 */
	private String generateZipEntry_ACK(String file){
		return file.substring(IN_PUT_OUTWARD_ACK.length()+1, file.length());
	}/*OUTWARD_ACK*/

	/**
	 * Zip it
	 * @param zipFile output ZIP file location
	 */
	
	// -----------------------------  inward pain009-------------------------------------------------------------------------------
	
	public void zipIt_INWARD_PAIN009(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);
			System.out.println("Inward Zip : " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				ZipEntry ze= new ZipEntry(file);
				zos.putNextEntry(ze);
				FileInputStream in =
						new FileInputStream(IN_PUT_INWARD_PAIN009 + File.separator + file);
				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				in.close();
			}
			zos.closeEntry();
			zos.close();
			System.out.println("INWARD_PAIN009_ZIP_DONE");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public void generateFileList_INWARD_PAIN009(File node){
		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_INWARD_PAIN009(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_INWARD_PAIN009(new File(node, filename));
			}
		}
	}
	/**
	 * Format the file path for zip
	 * @param file file path
	 * @return Formatted file path
	 */
	private String generateZipEntry_INWARD_PAIN009(String file){
		return file.substring(IN_PUT_INWARD_PAIN009.length()+1, file.length());
	}/*INWARD_PAIN009*/

	/**
	 * Zip it
	 * @param zipFile output ZIP file location
	 */
	
	// ----------------------- payment flux ach -------------------------------------------------------------------------
	
	public void TXT_PAYMENT_FLUX_ACH(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);

			System.out.println("Flux-INP : " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				FileInputStream in = new FileInputStream(IN_PUT_INP + File.separator + file);
				int len;
				while ((len =in.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				in.close();
			}
			fos.close();
			System.out.println("PAYMENT_FLUX_ACH_DONE");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public void generateFileList_PAYMENT_FLUX_ACH(File node){
		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_PAYMENT_FLUX(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_PAYMENT_FLUX_ACH(new File(node, filename));
			}
		}
	}
	private String generateZipEntry_PAYMENT_FLUX(String file){
		return file.substring(IN_PUT_INP.length()+1, file.length());
	}
	
	//----------------------- payment non flux ach--------------------------------------------------------
	
	public void TXT_PAYMENT_NON_FLUX_ACH(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);

			System.out.println("Non-Flux-INP : " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				FileInputStream in = new FileInputStream(IN_PUT_RES + File.separator + file);
				int len;
				while ((len =in.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				in.close();
			}
			fos.close();
			System.out.println("PAYMENT_NON_FLUX_ACH_DONE");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public void generateFileList_PAYMENT_NON_FLUX_ACH(File node) {

		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_PAYMENT_NON_FLUX(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_PAYMENT_NON_FLUX_ACH(new File(node, filename));
			}
		}	
	}
	
	private String generateZipEntry_PAYMENT_NON_FLUX(String file){
		return file.substring(IN_PUT_RES.length()+1, file.length());
	}
	
	//----------------payment flux ack -----------------------------------------------------------------------
	
	public void XML_PAYMENT_FLUX_ACK(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);

			System.out.println("Flux-ACK : " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				FileInputStream in = new FileInputStream(IN_PUT_ACK + File.separator + file);
				int len;
				while ((len =in.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				in.close();
			}
			fos.close();
			System.out.println("PAYMENT_ACK_DONE");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public void generateFileList_PAYMENT_FLUX_ACK(File node) {

		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_PAYMENT_FLUX_ACK(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_PAYMENT_FLUX_ACK(new File(node, filename));
			}
		}	
	}
	
	private String generateZipEntry_PAYMENT_FLUX_ACK(String file){
		return file.substring(IN_PUT_ACK.length()+1, file.length());
	}
	
	// --------------------- payment flux res -------------------------------------------------------------
	
	public void TXT_PAYMENT_FLUX_RES(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);

			System.out.println("Flux-RES : " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				FileInputStream in = new FileInputStream(IN_PUT_RES + File.separator + file);
				int len;
				while ((len =in.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				in.close();
			}
			fos.close();
			System.out.println("PAYMENT_RES_DONE");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public void generateFileList_PAYMENT_FLUX_RES(File node) {

		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_PAYMENT_FLUX_RES(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_PAYMENT_FLUX_RES(new File(node, filename));
			}
		}	
	}
	
	private String generateZipEntry_PAYMENT_FLUX_RES(String file){
		return file.substring(IN_PUT_RES.length()+1, file.length());
	}/*PAYMENT INP*/
	
	// ---------------------------- payment flux done ----------------------------------------------------------
	
	public void TXT_PAYMENT_FLUX_DONE(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);

			System.out.println("Flux-DONE : " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				FileInputStream in = new FileInputStream(IN_PUT_DONE + File.separator + file);
				int len;
				while ((len =in.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				in.close();
			}
			fos.close();
			System.out.println("PAYMENT_RES_DONE");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public void generateFileList_PAYMENT_FLUX_DONE(File node) {

		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_PAYMENT_FLUX_DONE(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_PAYMENT_FLUX_DONE(new File(node, filename));
			}
		}	
	}
	
	private String generateZipEntry_PAYMENT_FLUX_DONE(String file){
		return file.substring(IN_PUT_DONE.length()+1, file.length());
	}
	
	//------------------------------ payment non flux done -----------------------------------------------------------
	
	public void TXT_PAYMENT_NON_FLUX_DONE(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);

			System.out.println("Flux-DONE : " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				FileInputStream in = new FileInputStream(IN_PUT_DONE + File.separator + file);
				int len;
				while ((len =in.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				in.close();
			}
			fos.close();
			System.out.println("PAYMENT_RES_DONE");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public void generateFileList_PAYMENT_NON_FLUX_DONE(File node) {

		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_PAYMENT_NON_FLUX_DONE(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_PAYMENT_NON_FLUX_DONE(new File(node, filename));
			}
		}	
	}
	
	private String generateZipEntry_PAYMENT_NON_FLUX_DONE(String file){
		return file.substring(IN_PUT_DONE.length()+1, file.length());
	}
	
	// -------------------------- payment signed -----------------------------------------------------------------------
	
	public void TXT_PAYMENT_SIGNED(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);

			System.out.println("SIGNED: " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				FileInputStream in = new FileInputStream(IN_PUT_SIGNED + File.separator + file);
				int len;
				while ((len =in.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				in.close();
			}
			fos.close();
			System.out.println("PAYMENT_RES_SIGNED");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public void generateFileList_PAYMENT_SIGNED(File node) {

		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_PAYMENT_SIGNED(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_PAYMENT_SIGNED(new File(node, filename));
			}
		}	
	}
	
	private String generateZipEntry_PAYMENT_SIGNED(String file){
		return file.substring(IN_PUT_SIGNED.length()+1, file.length());
	}
	
	// -------------------------- payment unsigned ---------------------------------------------------------------------
	/**
	 * Format the file path for zip
	 * @param file file path
	 * @return Formatted file path
	 */
	
	public void TXT_PAYMENT_UNSIGNED(String zipFile){
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(zipFile);

			System.out.println("UNSIGNED: " + zipFile);
			for(String file : this.fileList){
				System.out.println("File Added : " + file);
				FileInputStream in = new FileInputStream(IN_PUT_UNSIGNED + File.separator + file);
				int len;
				while ((len =in.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				in.close();
			}
			fos.close();
			System.out.println("PAYMENT_RES_UNSIGNED");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public void generateFileList_PAYMENT_UNSIGNED(File node) {

		//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry_PAYMENT_UNSIGNED(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList_PAYMENT_UNSIGNED(new File(node, filename));
			}
		}	
	}
	
	private String generateZipEntry_PAYMENT_UNSIGNED(String file){
		return file.substring(IN_PUT_UNSIGNED.length()+1, file.length());
	}
	
}





