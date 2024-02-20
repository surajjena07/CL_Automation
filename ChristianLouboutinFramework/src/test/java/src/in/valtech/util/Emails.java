package src.in.valtech.util;  
import java.util.Date;  
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import org.apache.log4j.Logger;
public class Emails
{
	public Logger log = Logger.getLogger(this.getClass().getName());
	public static String strMailSubject = "";
	public static Date strReceivedMailTime;
	public static boolean verifyEmailSubjectLine(String strEmailDetails, String strTextToVerify)
	{
		//HashMap <String, String> hmapReturnValue = new HashMap<String, String>();
				//hmapReturnValue.put("TCDescription", "Email Not Found");
				boolean bolIsSuccess = false;
				Folder objFolder = null;
				Store  objStore = null;
				String[] arEmailDetails = strEmailDetails.split(":");
				String strUsrEmail = arEmailDetails[0].trim(); //cltestauto1@gmail.com
				String strPwd= arEmailDetails[1].trim(); //Louboutin@2022
				System.out.println("***READING MAILBOX...");
				try 
			    {
					Thread.sleep(3000);
					Properties props = new Properties();
					props.put("mail.store.protocol", "imap");
					props.put("mail.imap.auth", false);
					props.put("mail.imap.starttls.enable", false);
					props.put("mail.imap.host", "imap.gmail.com");
					props.put("mail.imap.port", "993");
					props.put("mail.imap.ssl.enable", true);
					Session session = Session.getInstance(props);
					objStore = session.getStore("imap");
					objStore.connect("imap.gmail.com", strUsrEmail, strPwd);
					objFolder = objStore.getFolder("INBOX");
					objFolder.open(Folder.READ_WRITE);
					Message[] messages = objFolder.getMessages();
					System.out.println("No of Messages : " + objFolder.getMessageCount());
					System.out.println("No of Unread Messages : " + objFolder.getUnreadMessageCount());

					for (int i = 0; i < messages.length; i++)
					{
						System.out.println("Reading MESSAGE # " + (i + 1) + "...");
						Message msg = messages[i];
						String strMailBody = "";
						// Getting mail subject
						Object subject = msg.getSubject();

						// Casting objects of mail subject into String
						strMailSubject = (String) subject;
						//---- verify subject of email------
						if(strMailSubject.toLowerCase().contains(strTextToVerify.toLowerCase())) 
						{
							//if (strMailSubject.contains(arEmailDetails[2].trim()))
							{
								strReceivedMailTime=msg.getReceivedDate();
								System.out.println(strMailSubject);
								System.out.println(msg.getReceivedDate());
								//Delete the current email
							//	msg.setFlag(Flags.Flag.DELETED, true);
								bolIsSuccess = true;	
								break;
							}	
						}
					}
				}

				catch (Exception exception) 
				{
					System.out.println(exception.getMessage());
				} 

				finally 
				{
					if (objFolder != null)
					{
						try 
						{
							objFolder.close(true);
						} catch (MessagingException e)
						{
							e.printStackTrace();
						}
					}
					if (objStore != null) {
						try {
							objStore.close();
						} catch (MessagingException e) {
							e.printStackTrace();
						}
					}
				}
				//hmapReturnValue.put("Status", String.valueOf(bolIsSuccess));
				//return hmapReturnValue;
				return bolIsSuccess;
			}
		}
