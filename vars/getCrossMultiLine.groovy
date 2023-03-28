def call() 
{
    if (isUnix())
    {
        return "\\"
    }
    
    return "^"
}
