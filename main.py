

#IP-INTERSHIP PROGRAM 2021-2022 LP3

import csv
import re
def CsvtoTsv(csvfile,_outtsv):
    try:
        csv.writer(open(_outtsv,'w+'),delimiter='\t').writerows(csv.reader(open(csvfile)))
        print("Congrats!! Successfully Converted..")
    except Exception as e:
        print("Error while converting csv to tsv -",e)

def TsvtoCsv(tsvfile,_outcsv):
    try:
        with open(tsvfile,'r') as _inputfile:
            with open(_outcsv,'w+') as newcsvfile:
                for line in _inputfile:
                    _resultline=re.sub("\t",",",line)
                    newcsvfile.write(_resultline)
                print("Congrats!! Successfully Converted..")
    except Exception as e:
        print("Error while converting tsv  to csv -", e)



print("......WELCOME To CSV TO TSV CONVERTER ......\n")
while True:
    print( "Choose The Option from given below :\n")
    print(" 1 .CSV TO TSV CONVERT\n","2.TSV TO CSV CONVERT\n","3. For EXIT From Main Menu")
    try:
        _input=int(input("Enter The Choice--->"))
    except:
        print("Invalid Input..")

    if _input==1:
        csvfile=input("Enter The Path Of CSV File {Including Name :}--->")
        _outtsv=input("Enter The Path TO Store Output TSV File {Including new name for outputfile}-->")
        CsvtoTsv(csvfile,_outtsv)

    elif _input==2:
        tsvfile=input("Enter The Path Of TSV File {Including Name :}-->")
        _outcsv=input("Enter The Path To Store Output CSV File {Including new name for outputfile}-->")
        TsvtoCsv(tsvfile,_outcsv)

    elif _input==3:
        print("Thanks For Using Converter...")
        break


