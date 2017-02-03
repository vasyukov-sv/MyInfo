package Impls.Info;

import Impls.Content.BaseContent;
import Impls.Head.BaseHead;
import Interface.Info;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by sbt-vasyukov-sv on 23.01.2017 16:53
 */

public class WorldTimeInfo extends BaseInfo implements Info {
    private final Date time;

    public WorldTimeInfo(BaseHead head, BaseContent content) {
        super(head, content);
        this.time = new Date();
    }

    private Date getTime() {
        return time;
    }

    private void setTime(long time) {
        this.time.setTime(time);
    }

    @Override
    public void process() {
        NTPUDPClient client = new NTPUDPClient();
        String url = this.getUrl();
        client.setDefaultTimeout(500);
        try {
            client.open();
            try {
                InetAddress hostAddr = InetAddress.getByName(url);
                // System.out.println("> " + hostAddr.getHostName() + "/" + hostAddr.getHostAddress());  //todo add log4j
                TimeInfo timeInfo = client.getTime(hostAddr);
                long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
                this.setTime(returnTime);
            } catch (UnknownHostException e) {
                this.getHead().setHeadname("Локальное Время");
                System.out.println("UnknownHostException");
            } catch (IOException ioe) {
                System.out.println("IOException");
                ioe.printStackTrace();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        client.close();
        SimpleDateFormat format = new SimpleDateFormat("EEEE, dd MMMM yyyy  HH:mm");
        this.getContent().setContentname(format.format(this.getTime()));
    }
}