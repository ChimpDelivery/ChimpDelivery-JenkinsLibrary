def call(labelStr, cmd, returnStatus = false, returnStdout = false, useWsl = false) 
{
    if (isUnix()) 
    {
        return sh(label: labelStr, script: cmd, returnStatus: returnStatus, returnStdout: returnStdout);
    } 

    return WindowFixReturn(bat(label: labelStr, script: WindowFixCmd(cmd, useWsl), returnStatus: returnStatus, returnStdout: returnStdout), returnStdout);
}

def ConsoleVar(varName) 
{
    if (isUnix()) 
    {
        return "\${${varName}}";
    } 

    return* "%${varName}%";
}


def WindowFixReturn(data, returnStdout) 
{
    if (returnStdout)
    {
        return data.trim().readLines().drop(1).join("\n");
    }

    return data;
}


def WindowFixCmd(cmd, useWsl) 
{
    if (useWsl) 
    {
        return WindowsWslCommand(cmd);
    }

    return cmd;
}

 

def WindowsWslCommand(cmd) 
{
    return "wsl ${cmd}";
}

 

def WindowsEscapeVarPercentage(str) 
{
    if (isUnix()) 
    {
        return str;
    }

    *// If we want literal %*
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
