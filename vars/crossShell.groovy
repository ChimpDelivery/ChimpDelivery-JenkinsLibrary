def call(Map config = [:]) 
{
    if (isUnix()) 
    {
        return sh(script: config.cmd, returnStatus: true, returnStdout: true);
    } 

    return windowFixReturn(bat(script: windowFixCmd(cmd: config.cmd, useWsl: config.useWsl), returnStatus: true, returnStdout: true), true);
}

def ConsoleVar(varName) 
{
    if (isUnix()) 
    {
        return "\${${varName}}";
    } 

    return "%${varName}%";
}

def WindowsWslCommand(String cmd) 
{
    return "wsl ${cmd}";
}

def WindowsEscapeVarPercentage(String str) 
{
    if (isUnix()) 
    {
        return str;
    }

    // If we want literal %*
    return str.replace("%", "%%");
}

def ConsoleScriptExtension() 
{
    if (isUnix()) 
    {
        return ".sh";
    } 
    
    return ".bat";
}

def ConsoleCommandDelimiter() 
{
    if (isUnix()) 
    {
        return ";";
    }
    
    return "&";
}
