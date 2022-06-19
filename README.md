# Cytils

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://linktr.ee/cyklon)

Cytils is a Java library with various utilities for development,
with Bukkit and General Java

- New vectors, with additional functions
- Database Utilities (SQLite, MySQL...)

# Gradle
- Add it in your root build.gradle at the end of repositories:
    ```xml
    	allprojects {
    	repositories {
    		...
    		maven { url 'https://jitpack.io' }
    	}
    }
    ```
- Dependency
    ```xml
    	dependencies {
    	        implementation 'com.github.cyklon73:Cytils:Tag'
    	}
    ```
    
# Maven
- Repository
    ```xml
    	<repositories>
    		<repository>
    		    <id>jitpack.io</id>
    		    <url>https://jitpack.io</url>
    		</repository>
    	</repositories>
    ```
- Dependency
    ```xml
    	<dependency>
	    <groupId>com.github.cyklon73</groupId>
	    <artifactId>Cytils</artifactId>
	    <version>Tag</version>
	</dependency>

    ```
    
# SBT
- Add it in your build.sbt at the end of resolvers:
    ```xml
     resolvers += "jitpack" at "https://jitpack.io"
    ```
- Dependency
    ```xml
    libraryDependencies += "com.github.cyklon73" % "Cytils" % "Tag"	
    ```
# Leiningen    
- Add it in your project.clj at the end of repositories:
    ```xml
    :repositories [["jitpack" "https://jitpack.io"]]
    ```
- Dependency
    ```xml
    :dependencies [[com.github.cyklon73/Cytils "Tag"]]	
    ```
    
