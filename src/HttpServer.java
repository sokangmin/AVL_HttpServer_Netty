/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.wini.octal.pipe.PortUnificationServerHandler;
import com.wini.octal.tasks.ImageDelete;

import java.net.InetSocketAddress;
import java.util.Calendar;
import java.util.concurrent.Executors;

import static com.wini.octal.conf.ConfigContext.*;
import static com.wini.octal.conf.Prop.*;

public class HttpServer {

    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void run() {    	
    	// Configure the server.
        ServerBootstrap bootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));

        // Enable TCP_NODELAY to handle pipelined requests without latency.
        bootstrap.setOption("child.tcpNoDelay", true);
        bootstrap.setOption("child.keepAlive", false);
        bootstrap.setOption("child.soLinger:, 2);

        // Set up the event pipeline factory.
        /*bootstrap.setPipelineFactory(new HttpSnoopServerPipelineFactory());*/
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new PortUnificationServerHandler());
            }
        });
        
        // Bind and start to accept incoming connections.
        bootstrap.bind(new InetSocketAddress(port));
        
        // ImageDelete Task : 1day repeat 
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, CONFIG_INSTNACE.getProperty2Int(FtpDownLoadHour));
        cal.set(Calendar.MINUTE, CONFIG_INSTNACE.getProperty2Int(FtpDownLoadMinute));
        
        CONFIG_INSTNACE.getThreadPool().scheduleAtFixedRate(
        		new ImageDelete(), cal.getTime(), 1000*60*60*24);
    }

    public static void main(String[] args) { 	
        new HttpServer(CONFIG_INSTNACE.getProperty2Int(ServerPort)).run();
    }

}
