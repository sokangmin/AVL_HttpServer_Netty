package com.wini.octal.pipe.ssl;
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


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.wini.octal.conf.ConfigContext.*;
import static com.wini.octal.conf.Prop.*;

/**
 * A bogus key store which provides all the required information to
 * create an example SSL connection.
 *
 * To generate a bogus key store:
 * <pre>
 * keytool  -genkey -alias securechat -keysize 2048 -validity 36500
 *          -keyalg RSA -dname "CN=securechat"
 *          -keypass secret -storepass secret
 *          -keystore cert.jks
 * </pre>
 */
public final class SecureKeyStore {

    public static InputStream asInputStream() throws FileNotFoundException { 
    	
    	InputStream input = new FileInputStream(
    			CONFIG_INSTNACE.getProperty(KeyStorePath));
		return input;
    }

    public static char[] getCertificatePassword() {
        return CONFIG_INSTNACE.getProperty(KeyStorePasswd).toCharArray();
    }

    public static char[] getKeyStorePassword() {
        return CONFIG_INSTNACE.getProperty(CertificatePasswd).toCharArray();
    }

    private SecureKeyStore() {
        // Unused
    }
}
