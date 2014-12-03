package tnaserver;

//Handles the scroll logger information
class Log2GUI {

private ActivityLogger logger;

Log2GUI(ActivityLogger logger)
{
	this.logger=logger;
	}

	public void storelog(String s)
	{
		 logger.logAction(s);
	}
}
