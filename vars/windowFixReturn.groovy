def call(data, returnStdout) 
{
    if (returnStdout)
    {
        return data.trim().readLines().drop(1).join("\n");
    }

    return data;
}
