/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* @author pamela
* It allows test log4j2 configuration
*/
public class LogDemo {

private static final Logger logger = LogManager.getLogger(LogDemo.class.getName());

public static void main(String[] args){

        logger.debug("BULLYING MESTRADO - debug log");
        logger.info("BULLYING MESTRADO - info log");
        logger.warn("BULLYING MESTRADO - warn log");
        logger.error("BULLYING MESTRADO - error log");
}
}
