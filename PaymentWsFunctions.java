
package pe.com.scotiabank.tbk.payment.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

import pe.com.scotiabank.tbk.payment.tramas.file.input.TRE2FileExcelInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRP2FileExcelInput;
import pe.com.scotiabank.tbk.util.utilities.Constants;

public class PaymentWsFunctions
{

    private static final Logger log = LoggerFactory.getLogger(PaymentWsFunctions.class);

    private static final String DATE_INVALID = "00000000";

    /**
     * Format a string date in the format indicated by the param originalFormat to the format indicated by the param
     * finalFormat
     * 
     * @param dateString
     *            Date as a string
     * @param originalFormat
     *            original format
     * @param finalFormat
     *            final format
     * @return a string date in the finalFormat
     */
    public static String formatDate(String dateString, String originalFormat, String finalFormat)
    {
        SimpleDateFormat simpleDateFormatInicial = new SimpleDateFormat(originalFormat);
        SimpleDateFormat simpleDateFormatFinal = new SimpleDateFormat(finalFormat);

        String dateResult = "";

        if (dateString != null && !dateString.trim().equals("") && !dateString.trim().equals(DATE_INVALID))
        {
            try
            {
                Date date = simpleDateFormatInicial.parse(dateString);

                dateResult = simpleDateFormatFinal.format(date);
            }
            catch (Exception ex)
            {
                dateResult = "";
            }
        }
        return dateResult;
    }

    /***
     * Format a string date in format yyyyMMdd to the format indicated by the param finalFormat
     * 
     * @param dateString
     *            Date in format yyyyMMdd
     * @param finalFormat
     *            The format of the data converted
     * @return a string date in format passed
     */
    public static String formatDate(String dateString, String finalFormat)
    {
        return formatDate(dateString, PaymentWsConstants.FORMAT_STRING_DATE_YYYYMMDD, finalFormat);
    }

    public static String parseNumberAndAddDecimal(String number, int ndecimals)
    {
        String valueReturn = "0.00";

        if (number != null && !valueReturn.trim().isEmpty())
        {
            valueReturn = StringUtils.stripStart(number.trim(), "0");

            if (valueReturn.isEmpty())
            {
                valueReturn = "0.00";
            }
            else
            {
                if (valueReturn.length() == 1)
                {
                    return "0.0" + valueReturn;
                }
                else if (valueReturn.length() == 2)
                {
                    return "0." + valueReturn;
                }
                else
                {
                    valueReturn = addDecimalCustomized(valueReturn, ndecimals);
                }
            }

            valueReturn = setFormatSpacing(valueReturn);
        }

        return valueReturn;
    }

    public static String addDecimalCustomized(String snumber, int c)
    {
        int suBSequence = snumber.length() - c;
        String number = snumber.subSequence(0, suBSequence) + Constants.DECIMAL_SEPARATOR
                + snumber.subSequence(suBSequence, snumber.length());
        return number;
    }

    public static String formatNumber(BigDecimal number)
    {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(number);
    }

    public static BigDecimal getStringAsBigDecimal(String amount)
    {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";

        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);

        // parse the string
        BigDecimal bigDecimal;
        try
        {
            bigDecimal = (BigDecimal) decimalFormat.parse(amount);
        }
        catch (ParseException e)
        {
            bigDecimal = new BigDecimal(0);
        }
        return bigDecimal;
    }

    /**
     * 
     * @param Metodo
     *            parseador de cifras segun telebanking: Mijail Aymara: 2016-01-11
     * @return
     */
    public static String setFormatSpacing(String number)
    {
        int start = 0;
        int length = number.length();
        String formattedNumber = "";

        String decimals;
        if (number != null && length > 6)
        {
            decimals = number.substring(length - 3, length);
            number = number.substring(0, length - 3);

            length = number.length();

            int cycle = length / 3;
            int res = length % 3;

            for (int i = 0; i < cycle; i++)
            {
                if (i > 0)
                {
                    formattedNumber = formattedNumber + number.subSequence(start, res) + ",";
                }
                else if (res != 0)
                {
                    formattedNumber = formattedNumber + number.subSequence(start, res) + ",";
                }

                start = res;
                res += 3;

                if (i == cycle - 1)
                {

                    formattedNumber = formattedNumber + number.subSequence(start, res);
                    formattedNumber = formattedNumber.concat(decimals);
                }
            }
        }

        if (formattedNumber == null || formattedNumber.trim().isEmpty())
        {
            return number;
        }

        return formattedNumber;
    }

    public static String parseNumber(String number)
    {
        String valueReturn = number.trim();
        char[] numberArray = number.trim().toCharArray();
        int cZeros = 0;
        for (char c : numberArray)
        {
            if ('0' != c)
            {
                break;
            }
            cZeros++;
        }
        if (cZeros > 0)
        {
            valueReturn = valueReturn.substring(cZeros, valueReturn.length());
        }

        if (valueReturn.isEmpty())
        {
            valueReturn = PaymentWsConstants.CONSTANT_ZERO;
        }

        return valueReturn;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String numero = setFormatSpacing("000021");
        System.out.println("numero: " + numero);
    }

    /**
     * @author eperez
     */
    public static BindingResult applyValidator(Validator validator, Object target)
    {
        DataBinder dataBinder = new DataBinder(target);
        dataBinder.setValidator(validator);
        dataBinder.validate();
        return dataBinder.getBindingResult();
    }

    public static void createFile(File file, List<String> content)
    {
        BufferedWriter bufferWriter = null;
        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter(file);
            bufferWriter = new BufferedWriter(fileWriter);
            for (String str : content)
            {
                bufferWriter.write(str.concat(PaymentWsConstants.TBK_LINE_JUMP));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (bufferWriter != null)
            {
                try
                {
                    bufferWriter.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null)
            {
                try
                {
                    fileWriter.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * Formatea una cadena de 20 caracteres al siguiente formato: 000-000-000000000000-00
     * 
     * @param cci
     *            cadena a formatear
     * @return cadena formateada
     */
    public static String formatCCI(String cci)
    {

        if (cci != null && cci.length() == 20)
        {
            StringBuilder formatedCci = new StringBuilder();
            formatedCci.append(cci.substring(0, 3)).append("-").append(cci.substring(3, 6)).append("-")
                    .append(cci.substring(6, 18)).append("-").append(cci.substring(18, 20));

            return formatedCci.toString();
        }

        return "";
    }

    /**
     * Formatea una cadena de 10 caracteres al siguiente formato: 000-0000000. Usado para formatear las cuentas de
     * ahorro y corrientes.
     * 
     * @param account
     *            cadena a formatear
     * @return cadena formateada
     */
    public static String formatCurrentAndSavingAccount(String account)
    {

        if (account != null && account.length() == 10)
        {
            StringBuilder formatedaccount = new StringBuilder();
            formatedaccount.append(account.substring(0, 3)).append("-").append(account.substring(3, 10));

            return formatedaccount.toString();
        }

        return "";
    }

    public static String convertStrDateddMMyyy(String strfecha, String formatoInicial, String formatoFinal)
    {
        SimpleDateFormat simpleDateFormatInicial = new SimpleDateFormat(formatoInicial);
        SimpleDateFormat simpleDateFormatFinal = new SimpleDateFormat(formatoFinal);

        String resultado = "";

        try
        {
            Date fecha = simpleDateFormatInicial.parse(strfecha);

            resultado = simpleDateFormatFinal.format(fecha);
        }
        catch (Exception ex)
        {
            resultado = "";
        }

        return resultado;
    }

    public static Map<String, String> convertStringToMap(String value, String cadForSplit)
    {
        value = value.substring(1, value.length() - 1); // sacar las llaves de los extremos
        String[] keyValuePairs = value.split(",");
        Map<String, String> map = new HashMap<>();
        for (String pair : keyValuePairs)

        {
            String[] entry = pair.split(cadForSplit);
            map.put(entry[0].trim(), entry[1].trim());
        }
        return map;
    }

    public static TRP2FileExcelInput[] loadExcelFileToTRP2Input(String path, String fileName, String userCode)
    {
        FileInputStream file = null;
        HSSFWorkbook workbook = null;
        Row row;
        List<TRP2FileExcelInput> listInput = new ArrayList<>();
        String celValue = "";
        try
        {
            file = new FileInputStream(new File(path, fileName));
            workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            TRP2FileExcelInput trp2FileInput = null;
            while (rowIterator.hasNext())
            {
                row = rowIterator.next();

                if (row.getRowNum() != 0)
                {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;
                    trp2FileInput = new TRP2FileExcelInput();

                    celValue = "";

                    while (cellIterator.hasNext())
                    {
                        cell = cellIterator.next();
                        int columnIndex = cell.getColumnIndex();
                        switch (cell.getCellType())
                        {
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell))
                                {
                                    celValue = String.valueOf(cell.getDateCellValue());
                                }
                                else
                                {
                                    celValue = getNumericCell(cell.getNumericCellValue());
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                celValue = String.valueOf(cell.getStringCellValue());
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                celValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case Cell.CELL_TYPE_BLANK:
                                celValue = PaymentWsConstants.TBK_EMPTY;
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                log.debug(PaymentWsConstants.TBK_MESSAGE_CELL_TYPE_ERROR);
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                log.debug(PaymentWsConstants.TBK_MESSAGE_CELL_TYPE_FORMULA);
                                break;
                        }
                        if (!celValue.trim().isEmpty())
                        {
                            trp2FileInput.setFieldByIndex(columnIndex, celValue);
                            trp2FileInput.setUser(userCode);
                        }
                    }
                    if (!trp2FileInput.toString().trim().isEmpty())
                    {
                        listInput.add(trp2FileInput);
                    }

                }

            }

        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        TRP2FileExcelInput[] array = new TRP2FileExcelInput[listInput.size()];
        return listInput.toArray(array);

    }

    public static TRE2FileExcelInput[] loadExcelFileToTRE2Input(String path, String fileName)
    {
        FileInputStream file = null;
        HSSFWorkbook workbook = null;
        Row row;
        List<TRE2FileExcelInput> listInput = new ArrayList<>();
        String celValue = "";
        try
        {
            file = new FileInputStream(new File(path, fileName));
            workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            TRE2FileExcelInput tre2FileInput = null;
            while (rowIterator.hasNext())
            {
                row = rowIterator.next();

                if (row.getRowNum() != 0)
                {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;
                    tre2FileInput = new TRE2FileExcelInput();

                    celValue = "";

                    while (cellIterator.hasNext())
                    {
                        cell = cellIterator.next();
                        int columnIndex = cell.getColumnIndex();
                        switch (cell.getCellType())
                        {
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell))
                                {
                                    celValue = String.valueOf(cell.getDateCellValue());
                                }
                                else
                                {
                                    celValue = getNumericCell(cell.getNumericCellValue());

                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                celValue = String.valueOf(cell.getStringCellValue());
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                celValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case Cell.CELL_TYPE_BLANK:
                                celValue = PaymentWsConstants.TBK_EMPTY;
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                log.debug(PaymentWsConstants.TBK_MESSAGE_CELL_TYPE_ERROR);
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                log.debug(PaymentWsConstants.TBK_MESSAGE_CELL_TYPE_FORMULA);
                                break;
                        }
                        if (!celValue.trim().isEmpty())
                        {
                            tre2FileInput.setFieldByIndex(columnIndex, celValue);
                        }

                    }
                    if (!tre2FileInput.toString().trim().isEmpty())
                    {
                        listInput.add(tre2FileInput);
                    }

                }

            }

        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        TRE2FileExcelInput[] array = new TRE2FileExcelInput[listInput.size()];
        return listInput.toArray(array);

    }

    public static String getNumericCell(double numericCell)
    {
        String value = "";
        try
        {
            value = String.valueOf(BigDecimal.valueOf(numericCell).longValueExact());
        }
        catch (Exception ex)
        {
            log.error(ex.getMessage());
        }
        return value;
    }

    public static String validateNumericField(String field, int size)
    {
        String validatedField = "";
        if (StringUtils.isEmpty(field))
        {
            validatedField = StringUtils.repeat(PaymentWsConstants.CONSTANT_ZERO_CHAR, size);
        }
        else
        {
            if (field.length() < size)
            {
                validatedField = StringUtils.leftPad(field, size, PaymentWsConstants.CONSTANT_ZERO_CHAR);
            }
            else
            {
                if (field.length() > size)
                {
                    validatedField = field.substring(0, size);
                    log.debug("El campo [" + field + "] tiene el tamanio mayor al definido [" + size
                            + "]. Se recortara al valor a: [" + validatedField + "]");
                }
                else
                {
                    validatedField = field;
                }
            }
        }
        return validatedField;
    }

    public static String validateStringField(String field, int size)
    {
        String validatedField = "";
        if (StringUtils.isEmpty(field))
        {
            validatedField = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR, size);
        }
        else
        {
            if (field.length() < size)
            {
                validatedField = StringUtils.rightPad(field, size, PaymentWsConstants.CONSTANT_SPACE_CHAR);
            }
            else
            {
                if (field.length() > size)
                {
                    validatedField = field.substring(0, size);
                    log.debug("El campo [" + field + "] tiene el tamanio mayor al definido [" + size
                            + "]. Se recortara al valor a: [" + validatedField + "]");
                }
                else
                {
                    validatedField = field;
                }
            }
        }
        return validatedField;
    }

}
