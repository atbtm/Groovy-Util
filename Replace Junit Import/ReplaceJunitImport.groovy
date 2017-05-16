new File("C:\\view_store\\SF-APPLICATION-SCB-DEV").traverse{ file ->
	if(file.name.contains(".java")){
		def changed = false
		def buff = ""
		try{
			file.eachLine{ line ->
				def changedLine = replaceJunit(line)
				changed = changed ? changed : !changedLine.equals(line)
				buff += changedLine +"\n"
			}
			if(changed){
				file.write(buff)
			}
		}catch(java.io.FileNotFoundException e){}
	}
}


def replaceJunit(t){
    if(t ==~/import (static )?junit.framework.Assert.*/ ){
        return (t.replaceAll("junit.framework", "org.junit"))
    }
    else return t
}
