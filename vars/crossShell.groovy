def call(String cmd, boolean returnStatus = false, boolean returnStdout = false, boolean useWsl = false) 
{
    if (isUnix()) 
    {
        return sh(script: cmd, returnStatus: returnStatus, returnStdout: returnStdout);
    } 

    return WindowFixReturn(bat(script: WindowFixCmd(cmd: cmd, useWsl: useWsl), returnStatus: returnStatus, returnStdout: returnStdout), returnStdout);
}

def ConsoleVar(varName) 
{
    if (isUnix()) 
    {
        return "\${${varName}}";
    } 

    return "%${varName}%";
}

def WindowFixReturn(data, returnStdout) 
{
    if (returnStdout)
    {
        return data.trim().readLines().drop(1).join("\n");
    }

    return data;
}

def WindowFixCmd(String cmd, boolean useWsl) 
{
    if (useWsl) 
    {
        return WindowsWslCommand(cmd);
    }

    return cmd;
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
