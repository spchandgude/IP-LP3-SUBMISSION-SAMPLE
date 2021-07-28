# Internship Program (IP) 2021-22 - LP3 Phase.
# csv to tsv converter.
# without user input.

import pandas as pd

try:
    # csv and tsv file names
    csv_file_name = 'EQ010114.csv'
    tsv_file_name = 'EQ010114.tsv'

    #read data from them
    csv_read = pd.read_csv(csv_file_name)
    tsv_read = pd.read_csv(tsv_file_name, sep='\t')

    # write the data to new files
    with open('file.csv','w') as csv_file:
        csv_file.write(tsv_read.to_csv(sep=',', index=False))

    with open('file.tsv','w') as tsv_file:
        tsv_file.write(csv_read.to_csv(sep='\t', index=False))

except Exception as e:
    print(f'Error: {e}')




