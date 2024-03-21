sudo apt-get install mailutils
echo "$MAIL_BODY" | mail -s "$MAIL_SUBJECT" $MAIL_TO