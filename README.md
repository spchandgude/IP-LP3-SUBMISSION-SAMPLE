# csv to tsv converter
  Internship Program (IP) 2021-22 - LP3 Phase

#info regarding the files

csv - 
      A comma-separated values (CSV) file is a delimited text file that uses a comma to separate values. Each line of the file is a data          record.Each record consists of one or more fields, separated by commas. The use of the comma as a field separator is the source of the name for this file format. A CSV file typically stores tabular data (numbers and text) in plain text, in which case each line will have the same number of fields. 

Example of a csv file -

      John,Doe,120 jefferson st.,Riverside, NJ, 08075
      Jack,McGinnis,220 hobo Av.,Phila, PA,09119
      John Da Man,Repici,120 Jefferson St.,Riverside, NJ,08075
      Stephen,Tyler,"7452 Terrace At the Plaza road,SomeTown,SD, 91234
      ,Blankman,,SomeTown, SD, 00298
      Joan the bone, Anne,Jet,9th, at Terrace plc,Desert City,CO,00123


tsv -
      A tab-separated values (TSV) file is a simple text format for storing data in a tabular structure, e.g., database table or spreadsheet data,and a way of exchanging information between databases. Each record in the table is one line of the text file. Each field value of a record is separated from the next by a tab character. The TSV format is thus a type of the more general delimiter-separated values format.

Example of a tsv file-

      leave	pay	sleep	lake	should	space
      pretty	according	remove	north	put	standard
      but	printed	up	chance	early	plate
      warn	independent	area	given	court	height
      depth	score	captured	finest	shadow	pile
      mother	been	result	pipe	door	flow

#modules used
pandas.read_csv

-to install this module
      ~pip isntall pandas
      

#files

-this folder containes both the csv and tsv files for example purposes.

-index.py = .csv to .tsv converter and vice versa but without user input.

-wuserip.py = .csv to .tsv converter and vice versa but with user input.

-extra.py = .csv to .tsv converter and vice versa but with user input and some extra if elses to make it more user friendly with continue and quit functionalities.
