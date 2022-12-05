def call() 
{
    currentBuild.result = 'ABORTED'
    error("Job parameterized!")
}
