CREATE DATABASE  IF NOT EXISTS `procity` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `procity`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: procity
-- ------------------------------------------------------
-- Server version	5.5.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bairro`
--

DROP TABLE IF EXISTS `bairro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bairro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `nome` varchar(120) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bairro`
--

LOCK TABLES `bairro` WRITE;
/*!40000 ALTER TABLE `bairro` DISABLE KEYS */;
/*!40000 ALTER TABLE `bairro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bairro_aud`
--

DROP TABLE IF EXISTS `bairro_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bairro_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `nome` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_ky0x0xl1s9g8v0c1lp44ra83n` (`rev`),
  CONSTRAINT `FK_ky0x0xl1s9g8v0c1lp44ra83n` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bairro_aud`
--

LOCK TABLES `bairro_aud` WRITE;
/*!40000 ALTER TABLE `bairro_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `bairro_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto_conteudo_ocorrencia`
--

DROP TABLE IF EXISTS `foto_conteudo_ocorrencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foto_conteudo_ocorrencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `conteudo_binario` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto_conteudo_ocorrencia`
--

LOCK TABLES `foto_conteudo_ocorrencia` WRITE;
/*!40000 ALTER TABLE `foto_conteudo_ocorrencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `foto_conteudo_ocorrencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto_conteudo_prefeitura`
--

DROP TABLE IF EXISTS `foto_conteudo_prefeitura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foto_conteudo_prefeitura` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `conteudo_binario` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto_conteudo_prefeitura`
--

LOCK TABLES `foto_conteudo_prefeitura` WRITE;
/*!40000 ALTER TABLE `foto_conteudo_prefeitura` DISABLE KEYS */;
INSERT INTO `foto_conteudo_prefeitura` VALUES (6,'ÿØÿà\0JFIF\0\0H\0H\0\0ÿÛ\0C\0ÿÛ\0CÿÀ\0\0ú\0ú\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0\0	\nÿÄ\0G\0\0		\0\0	!\"\n1A#Q$2aq3BR‘¡±&%CFrğ)46Tb‚ÁÂÑÿÄ\0\0\0\0\0\0\0\0\0\0\0\0\0	\nÿÄ\0Z\0\0\0!1\"AQ#2aqB‘¡±	$3RbrÁğC²Ñ%&4Ss‚ñ56Tcu’“¢³áDEUt£Òdeƒ„ÂÿÚ\0\0\0?\0ßãŠSŠSŠSŠSŠSŠSŠSŠSŠVºvS^õÁ¥3íıwUtËJà+rË.y\Z†…ÓCæ°-%>©$ÅB/˜S„Ác\"{y8ÏĞ•ƒ¥UDƒ2{ºYl¬ì6°æÂêQ\0|ÍG\n;ª&†l­´ÅGÑ³¬™4zO)`d´Ë½‹Ã4)Œ‘-k’¸7Ø§)À¬‘ˆ¤êÍ7%äF`\0,4«MíµC*+°¤-—t%ÖÈl8ÚÔ/îB•·¾±uïÔ¢GÚIfkşœİÛMs×µä\ZÒ°ŒŒJjšÎ¾‰Cì…+PÄª™Xîé„xÎ9½QF:!ú\"/=ò/Ñ¥½~6ª9n¦$d¹¥çJ‰¸ÍsV=êÔ¤$ö¯î®÷©»™mİWåá®·Ö¸#×;«®)û}•¥ºáa¸Á ¯í÷I]£è’#pFº6¨µ	ˆ1q9,âF9Ç÷ŠF‘z™Ï‚êP\Z’æ€§‘%¦ÛÒUÓAmçB¼o{v\"õˆ÷óf6ö´Z]ªZ¦¶‹…ºmCÆº¹ÚWŒ2o;i®¢£-3Ìmç6Ï3—£V¸BÉæ!öáÈLàD$)ù\Z¬ƒ.W}|S+W²Ò¨à[ÏKN}Ö¬{°:‹Sû¡§unÄìÍ	uÖ{!‰kÆ+Ms_U¸G—Tõ>\'Œ²—Yª“€5FQå\r9xÈ3»9ÏpüKgJÉ=-·ÄÔ¹³˜“#ÕAj#{ÛD§ä¨Ÿ1¦Àù^“İü¾wv«zokë\r{©õsI@#Q×=bk¸$oêl*Øyyt“ºHšü1îÜL$²\0”^$ƒÌïúÌJÒ:ïº­²Ü˜Z	Ó)PêãËtëßÁ\r§»a¶÷¯‚³Ü-£«µc«Æş×·5“ r‹u¦9‹Öàª£òÔğíea¹™~ˆæâ\0˜K›¸Ò(ğYØâÊñÆCœ÷ä%¤|ª >’ĞR„©?¤KKRÑ¨u±RB> ƒ§ßXşeiõs×g™mëg4BÎ‹Wzşªñ”FdúİnÀ¢‰šöToPÉJ’BiÂÎ§<døzƒ\0†@;ç\0\r%K±¿–ÖëÒ®,bsŒ¼8\'k‡\Zæ²-µĞ¸åùÚ®S\\l	U³¯tm©7ihL,Ê†º°dÌL&-5•îeI#phm5Ë9<D¦1H‰\0ÎGœ¾sœòB¬“óµP$íp<7 x@\0Ÿ3j¬ê‹«-™l²$±˜zhn4–‹’;MP@­º¥Ê³Š•6Ã&KáC~2L™µİ	\nÔ7(0€œœfú~\"ñDfj™Óâ*dË5õ6\\S\ZM¹²´²£ã¥Äs	ÏH©û®{Hm¿•³U»Û³}Kƒg„º<ÏXWÁ–G¬^ÖGg¿_@û€e9mŠÛÖ”yşBOœ\'0ÒÎ0®ÃÌµ%IU¼kê›í\r­·îBR¶U©\'¦’@ëï\0ùŠîUÊkÖÀ¶óF]õ=¾Ø`\0?s[Øi\nó+à*\ncTq…Ã>Y\0ñÔ8à¥IêÙS‡*2ÊV…$§Úñæ.+6r\Z¦¯<RœRœRœRœRœRœRœRœRœRœRœRœRœRœR±E£zÓ‰1¥«^U¤Ìä­pØ–Á†\'‰D­éYhZ£Ñü=NU«<Ó@\0F>âÇ|c<TæcÈ|(¡\nP@ºˆñü<ë\0uØkOSô£`¶:™‚²X¶\rC.`İ’˜ê4#{HL¹ùÜ¶,áaÄ3´¹àÔéÄTH\0Á“<±õ6½KG+PÖlŸø_È^×êmáUu¶H÷’“×{ñcï¤h·\\—U÷ûÅ1¯U„z¨Õù¥@Ù.k[iEİHV\'é\\„\"Ê×‰K„„´¤*,¥bI’JÆ;JNÃá¿óüü«ä\'ñ.amH†wmHCeã¦şÚ^zÎ!Í:€.@¯H6³AáûeÓ2÷°®ıfµ4Í.ŠÂ`…ùú/PÃUŞT¹Ò&{-á¼yZr6ö×øë	e¡8\Z‡p„,f6…*JA¹éowó½N‘…:‚”Èh7}Ù´´³b•#œR\nŠuX€v¬±[[´6@¯MCÕ}©ÚÏôW·í‡tÖºK«èyõu¿A»W/­ñ¹å®DiŒÑìkBÿ\0lL©:oå(ûá¿«#ßk~©ñª(Ã0ù%+u<äûqšrB·ÚÊS\r–‰ÛÁg­pšådõ\nİëæGÔ‡Xõƒ])*îí×&h#Ú–Tñ29U-{ÊºÌ¥0Úq‘AÉ”%rPµ¯-*Vâ0K|MíÈÔÚ4ŞäÔèò0³-w9i-£CË1ã6âºÛ”Vì6>Ö”ßÀÖ>éÉx_–/T*>öØ‰M8û:ÛM%ÙÊAêKµCH¾é¦ÎŸè2Æ‡g§g\'j²¥ÄÂœ•€¼\0ì¦LNBY†t\0Õ¼ˆøn*câeF7\"1ı<Õ)Gö–°”ïÖÈ¿íXõİdPÇcÓş›÷$ã`¤Z£\0‚lÕ	”ìLEÚ\"Âû]âÜ×I;+ >±;@æÖ¢ä$7-1R#CéŸŒ%›	l›_kíøT‡[IÔ—Zdş»Í¶êGû.÷.|Õáz©X¥¥«ö®İ[§]»)+N©:A?ÑÙ:ŞÖ&•.I¯*wÂøw#¢>ÁàI•’³2Ş(Jğ$X÷Yõy4<ÊéNşÕÉÚİ*?ñÜí\r5/K©7<¸ØiS—é©\nzÉø ü«ëµll¡§ğiÎ¾õÛH%[W¶”´giŸL¶õrD³5ÒJñtIEh“EÀ[P™42·^KÃqEé8ÌEÈKÑÖvÓ°6ßîª¦°üÛ\rÇ9’0õ“¶—¡aÚZ?°ùï~÷¾²kİOÓF]\0¾*9^‰³¥{´’g‰EôÄeıª ˆù&lBĞøµ{‰1p©Mî7!L2‘œ˜Ÿn”`¿LCÀ¡ç¶º}ÛÛåT²0\\âSÊœÂ6ğä¶b„ÙÛxïc¨:‚FlvÈôØ³\"Î¯¹½ÍdY’­\\‚j¶^µè Ø5Û¾Ç‘DÕãy‡·G 1„XiŞÜ”¢\\HÎI•\nRˆ%ı¢˜Ë­)í·vêõñï¦ï&V	å·\Z*)*Ö.…yûÉ·M÷9Øéœ_µ*ğ­(EFéÍ}°äBHÙíĞ6èEz­Zvæœ@,³Œ\np”XÇª\"ÁŒşœ¥NêùÔ@‰­wztì¾êÒ:Á\"ÔxwO²ígÍ‚A©…S\n‚ï‰4¥Ñİ,\n‚[å0)V<Ÿ JlŒİ<Ò©9N” ¼Ş±Ğ€oq¹¸ùT‰Ø3JD|IÅèÕ!Ii‡\Zl“µ’—Cå6½Ô@=ÓkÖoê\\Ò*%]9O£öª€Ù(•EÖ+IE³A<Š¿ƒÍ¶-:\\Z–lªÁ‚áÑ©IM’¹y¸\r2ÓÙ‰)@K5I˜ï-7uíDxßìª‰#…\r\nV\'\nëkZ™Qy‡›.(„¶°óM /Ü||ªDowI¹Oû&IB Ô;^q‚Á5Ò‰Ô¯Pœ[ö<ıá®›¬¦Öç$|Ô*W”î<Ÿ>ĞÜùbi‰qÕ/­ÆæŞ_óîªtà\"75†ŞB\\ÅuÄ6â¿mm/C„[p±×ÌÕí£õÃ\\¹t÷Ğmfµ%µ<²ÉRş9EŞÚÅ±d0šT*¢HÜÚ¬@­L°Çç•q–s]ƒ\r4¥ËF½×ˆ¹L€r’j¡·RÅ¯¥Åæ®øúêºmºFıEïÖ¾hÄom%²úñ®öuÏec[÷<mŠØõ|Ò–¶¡qjÎù¦]cÙ•Œ€ÇÆ%\ri4\r§Ğò&»<!N =@ÁH ‘µ¼êS.-M¸_gBÊÂY1ŠœbÖ¿®æéq@-®Ößb*Úœ^ZZ0‡ê®MíŸS^™¥·ê+R¢Â÷U˜ÎR6\"Ê¡ÕPoˆ½2AähüEâøç’ªzuÛéIUR´‚l‘ÕFÀØk’Æ{ÿ\0‡ùñPW)N)N)N)N)N)N)N)N)N)P³jw¶›Õè\ry#dµ-K¶ÙNğº­ ¨zùÖÉ·\'\rQ³ÈO%¡gI’\"jm¤şıÍÙÁ½XÉÙpF„k>:˜[†ä…¨%¦­«ë8¢z%–w^Wì¶“o/P´Í³Ş)Å®ÿ\0­VÅMÒÅ[O¯7Ú;e´Xè.\n;~@™\0©tBÜ$´‹§z%±`$èZ\rÌ‘¡iw\'V\r!Ù%¢Äù/Bô%!<–ä•¥<Å*@B[pa¥	%h •’­ú\rÅTÜDÎ˜ó\ZPI}‹³{ßSÒÈ…€QòíÊŞˆ.Â2-S“—\rgk-Ì0DL”TØzdÑÆ,BU8òM‚ˆh¿óç_eö/J˜€áiÇlh*Kq`ÇœZWsKqÜx\r\\ÇOz¶éÿ\0x¸î¶Š×rÂ*[e¾\"ÿ\0HíE^üF¶1qBğuurB¥ŒÊŒaêJ9H’cÙ¯#!Ä˜G†•}õ(–_l’¶ÜH PJT<º¤õlA­Mf4õZêí±®V—¸Û?¿º™|#€gV•l•¥²¨ÚÒŞ@ûYAŠ¦+ \n>‚3ª@„¥¯aÁd«Ê@yÊpwœ–ÓÎÔ/¿ãıõS-É˜ÄvìI´Æh”˜É0âº´\r”†Ú:S‰M‰^¥ìAoV55z§nØå• :oÑúCFXÛª¶[³$²ú­éC!’°5bZõ|Ñ3âr$rUÊZ\\İš†RAZ¡2L0v\"ï„Üşà}ö«TteÉp[Ö$Îå9¡1VÛÉy-‹krqeTuxÖ\\Ù]ˆêª”5O2Ùó@õÁ¡‡AÔ¶ƒzÓ*³ìÖ˜ŒæF‚¹´b€¹—µ²\r[IÊ:œ”-%-¼NTé Æ–Ò.­üÛWÆ1nsÃ4ÃBBK³$8¤!^ód´‚‹÷…<¥[Â«2ß©ô¾¼¡n\Z_SzovéìÆfVİsLët¦ÉÀ”Xk$©Téc„_XQ²¡i“-\Zöó–»e©)‹Ì1?‰…<‰!ZÁ±±ñ±µ@‰«ñwéHÍÃå¹8ÃÖ½)*%ÒœJS©(G1*l›•^ö—õ4«]¡½I:rÖºãÓÚM¢²ÔE_ö­ õi£«+¹«µÿ\0Q¸ÄdÉ§L©Ÿ]äg”ªbk	­JßÍNc’ÄªÔ\"O“=ÈÁ9Ö––I¸PØ\\o½[p¨8cÑP¸«µ²˜î·;fÉİÓÚ‰\nÜuoÙ\'ÄoVO×*^¦¨L7tE}2j=÷Mm\"jÊtè‡-r˜Ä!ÕTnl\'f\0™…Ë¤dyrqÉHJ5a™EhY§` Í\"u‹ÛÊÕ^Îqîä9ãj³©eïí$·İ6\'WAÔUs™zîfÍÍ®mPëOHu\'¯Õ¸E²ÕE`KÎˆ;W{™î)s‡­SõŒpL$\nšZ‚S€\0\ZAàÜû€ãT‡Á\'@?nÿ\0Ï¾«œÊÙ1P%Ú@Q“‡ kIÛ½Ù¯k_tôó¯ŒãwKêL§¥\ZqÑöÊÃ”Ô(Œ¤¹£Ê¹Ì¥dPÖF‰ÌàJ¢¹É$ª9ªİ,J\r\n…ôË?¸…ÈBVOèGá¿Êõ>.“”Áí8,•ûKåö‚OÖ%qA¶ç­ë¼ÿ\0£ÖøÇv6S´xÕÆ–£^\ZjÊ[Aí<i(lÑŞÇY:M‘C3Œ¸©÷âo;¹@\0R¤N!Ø\"Àf†‚’(uò¸ş)8T+(Vˆ˜V+Jypµ%Óİ7»<«ÕI\0Ş£ì~ö»¶úÍé}|ÕŸÕDzâ¸jÑxşNI[kÀµîˆtüÖ¢Cb¶:GÛ‘··¹8\rbğàyÎF\"RE‚–šš 4ÕĞlE€=jYw*\"2\\…OmE@!Õ5–4îoÈi+Ûn„íÔUÇõÙ{‡¥^Ñ‚Å™©OQÈqRö¦w$ v6œş#3Ÿo½±Ö/*;…ç‹>%y›Ÿ´ä1ÀS£çøU¸3 ¨„……¶JÉJÃd÷¿QÅ)\r‚¤&zŸ\'ê“Óc\\®pÎ-m¨³lø#ŞÈkË²Õ£xi9LzFñ›\r‘YN~ J¥ñ[™‰S²¤K	9` eÌQ@I\nê<®>7÷T8;æÊe#Éh8»ÅÆ#–”æÀFûq^Pµ‘%Z¯±ºw‘uş×]\ZıvÇÚ5[fô/©Üƒ¨öÇ¼HeJËÏ¤lx¦\"T™~ÜÉ(¡îhch#Ñ’·\0æ0œ\'%*ŸtÁ´¸çÕÛÃ¡øR=%ÿ\0¤a™X[mŒ$¡h6,”=ÚËéRA½ÈZÕ¶ö$\Zëûe	‚0íº=­êOÒ­|3V :Êº½y}¨\"U†ÀÃ¼g¶ûrƒíit‚«=…ü	Q·µ‰jÆœ:”­j¼œ‘êvNÇsõÿ\0•[Î!Æ¡^DFV\n—³ÑØeÁì¥Çb„¯õWìn/ÖÕåHôÊ9½\Z‰#Ş;ÿ\0N¤¶ŞË|¾ÜödİğÂ ‡GQHâusEo½HU½L¢Vsq‰Û°nHP•­pÊ\'\"(¡îşËÚ®øpr&\"µ%œMkIm¸<è³Ên.¥ 5ùŞ­¬¢£¯}ˆ±&Ù:kÂç—Váí^ØÙ[‡g£*RôG[,Ö¨tVĞêÔÌ¥\r™±²R˜¡GØ¥QòCÚØ†ô‹Ğ%ËãDZrÈ	8äo”„€>·xû¼*Š”¹e.Çf:™Ô41Ï	%zoÌD‡q.£HJ“ªÉÜX‹x/}@¾º‘E5Ûk&Èõ§QjçGi‰S¶‰\Z5ÿ\0p/dÉÑ×Q©u²Ş3±½Å!¡XîÛïÜZÖ¶F@ĞƒI;%@RİüOáR]B\\l²]m²êBˆ;4…­(m[j_0İa´•)aĞFõÏQ¶ŒKT¶[aÌ¬væËôúÕIÅ÷°ñË2ÆC±QÊşw?V©î¤ˆQvÛÈ”Èÿ\0˜ÂÒôìâÔ©éØ£F¾>™&\0%˜ïm_mW)¹qZLiI»Àßœú92\Zdiq(Caiêy#˜‘ŞVæ¦eÕj§bmûSOŞš6é3c>Çßö\"$I£¹r¢\0µ•µ6ÁDq‹$_’,J>¬dX˜ïU9„z¤Ÿ‚Ÿ}Qê†âÔ\Zx/J‚´©…8UÓ’—mÍÃ–T}Ãz³ö§fÇÖÆç¶G.ìÏº4;µ«NàØêØàœ*Ğ¸¶¯H!”y0QÅE˜X‚0!Î3˜(AÇcå\\‡òœRœRœRœRœRœRœRª+«¬RÅ€Tpíü×è+tëa´!ŞAj·ÆNP¥ÖE `1ƒcêEkÈPxÓ®dğz$²Š0àº0 59fš@ùØªŞu)E-8•òù¶ºHJô+õ	ÛPV’5mkj°v|½tµSQÖT¡q¹R/~Çeëæ–èy.L®Ëb¦¢9Ã]ëÓ^mic©íFA˜%~äßM>Iäû®ïßüv;UĞÆÆßA,”àè£ ºI™ 7b‡dÉõn…ùQâjÒ¿n°USvnÿ\0M.“Á:{P:ß¯œÕµÍöBı—Ç+ûjá„¸Ù—a×#Ö¾DJNôñ,eZW™	+òC”­H¿Û\'î?m‰j\ZÜU¶¹ëşï\n¶áàrËr‹5ıIs´¼ò”ïÕs˜íÜ[9ŞY@dx#Î¥·Iı‘‚Åº‡ìÖ¹Æ6>ÁÜD[mÆß/¾)Gº†ºß_¨GVZ­•«Q)ŠdQpdÌXÔF«#ß7(D¥Åaæ¥apX³îª§7.D:¬ãiŠî°†Ö-Ë)+uD¡H%K.ªê^à\Zì]SävgOM‡İ½q¼ªjõ>ÔÆê:¯jjgøÒğ\\š°yTßØg¤‚æØlŞHÜÌµC3³ÃğB\"•`½¡ŞŒM][y\\Ô–•+ŠuæÓÊPå‰Ô–™xûîXqµ’5¥JÆwMíR1ûŠÒ¹Ì­¶·eÈêƒ°’&ú–kZğImÓ·Z¦õ5Ñ,(uy®2˜èˆ’5&™­\'Õp÷-Ä-!9,¡O‘M ¥V÷Çãò¯½®63Š¥…ÏVÙ‘d#[ŒËxxv™%ä¸U¤›ÙÕ«bjwÂ:]\\qr]±–T¦ŞÅe(\\0²oçY¦ıÉëÙUİÑÅM“_ªØZ¿º$psÁcZ¹\"¤èšæ‘ó)Ò«§Ëğ©nËÅqÎs\n…\"[(-ò~œ©	:ï=,¿kO1¾ùÀ\\TOÖK·L­å!º÷‡©õĞ£ká×®¶GiÛĞ)Öe5U}l¨9l\n#§¬ê_]â’hÛ^“C€‰§„ÇäÁLl-­CN¢?[¢~_Æ«\\Äq4üEBÀá³¥:#¢,/\\Ÿh¾ôµ>ùQRNá;üME¸¼WXækz•é%i§÷Öíè™âòĞ{^æ¤—Ç/¨G5‹#@YRæÆ8¡@Í–bf§Bri‹Ê4Å +&Œğ†&ÕÍl(l„®jN%Š\'µ.L‰ÏÍ’Ê»:€’¢ú4§³„7`	Ö£¥$Ÿ\Zµ;¤â®]ÊŞÔé;³*†Mm PAœn‚ušf:à4DrP¦Ìp\\‰ŞL§	P9*uløoÂ•k€ˆB\Z|è“™i½ì\r·ëR£csŠ-©üU–…Š?0–––OÁ}ß%)i°7\'az‰=,+ZVE¡1+ÅèÇ	¹äùØÖ½¦Zûq[ÒBôB•[ÂU¨ZcˆÏaXVAh“¦oÆ	Ï§üª.<—vU¶ò¤9)bûÒq€â­¥M5=ä„í¥Æf49iÛ¢•Ír]>«Ø%…B\rüßÃß$¿šíÆ}\r¸ä®4ƒ#t’¹šZïªÅMšµ2õÈÚXU!hoVœ° =:2n8IM,Yøä§ÒvX÷ì‘ÓåQÿ\0‘8£‰í6§¸mHƒ‰¼ÚC}Ô`š„¤éè›*ß­~¾>¯©‰&ÚoÌ&{Ñ&~èôtê®Á¨9RÚmú©”Ö¢Gf8Ç*‘7%\\Ğîü‘Áy®1³W5Bà&Z •Y	Y’^Ô€uo½öë}ê[¿ÑiLøËŒ69M´˜ø‘-•)E\\Ö{JVd’y…e@mµt½zkÖTıM÷Š¨rèÙ!œV¯°\nıSGJJ%Ôüö‘Š75]HX}‘¬¶çe\r\nIdwPafX‘ãÜ2K-j¿N¤øÕ9•—°ø¼–ÄÔ²Ú@‹:èB‰¿u.-Ô¡{_Nõš#ñÅ5ıs *úŠtÛÙw-cĞ½\'¾«»õ|Ú	³aLÓ7µñ\'ÄÑº;’*Vµ¹½©…ÜƒÜKê£ÂÊôEê\Z`aè¹Ä‘cşî•!ÜOÇ\nYpb7x…«™\Z|d§ı+¢İ	î•:º\r°õ^Ä*Ûê¹šKŒš[o1z¢\',»éf¦õêpş¹¼©¢ÄMZ—ÁœÛc¡XAC]ôÔ§	r#>¸èUúˆdƒb<¥3ŠÄRBKàóa¿İGtó[~ÒpÛª_OKÔº¤i7ÍŸzØ*v¢ô°Şè·™	¥(éöÀP°(­¥5ZŠ¥Fêìª!`kŠŒ*\n¿½BÎÜ-j‚µb5¢,Â›ÕäO,oã¾Âß/çß_%ÃD#aƒ°—i\nP!ø.		úÏ…ö”\'_´½*A¹îÖ*éÜş…Õº¢–İX_P˜2J©šˆÛN·QÖW×}ÜšJK¤@¯T-#€âIÈ‰_ô¤HO)7³D\0PÅªY)¿M7Ø\rşß/PË–êãßÅ\'FyV×TFfÅZVL–„hnÁ$í«Q7¯œî¦û\'8±ßu\"l^¶î\ršÿ\0k\0ªin¢º˜ã©s¥ÕÊXEµ§0y\"Ì¨Â´N	[™şšsÄ‡\rY-°€(VÃ\n¯?ç¥¿…UL”Lkˆë®¨!•á¯)¹\r:‘u)Ödóh\0nPâm{[Æ¶_×ú¶ÒÏ¦ã|xd!zbÕêohØŠáíä7§™JÙÙÚ6sÃ\n\"K, -ÉÌK„€¬€!!0Ó€€²BÊ7Zşu,-ÕÙN›,îá¹Wxû[«¼­üNçÇz ]-Û;rªã5j=[ê\')êQdÜ[°ZØÒê†¢¿é9Ä²&>İMN	Åñ8Ş6èÛ>e\rìŠ”„¶äMùPŒÀš§H=vÓçSVŒ9l5…¼ÛÎDÈ­¢BCmƒËL†U{¸‹ëmÆ‹g¸PT N7C¯Z£sí¶ØWï‡F–§Ñk?ğ{^œ˜ÙéºÏ`ç5á&O%ö]·Z?ˆêÆnQNùBÌ…™ÇcĞ´hğg¾3ø¥ {¯¿ğÛz§Š$âJüÅÒ ÏyÖ_ASÏ4,;å\"P`5af•²¯}ºØşÊ½o­§4ªzdÛ-\ZãeÁ·4ÕJgÛ%RÉ$Pù9š[:7>ì\n©–¾HKsLÚªFÜzH«{Ã[âÖƒV>	‹N<—‚à=/Uª\\pù³Œ¸…%)Ä­«Úú•\0óE²\r­{Û~•±<aš7kBÇ57±±25¦)c;3J@ kknDŸ,’\0Q`ÆÀ‡Æ1ÉM\\·§§§§§§§¯J‚	TI©”R„ê*<°œIä\Z–q&”>áDä\"±œgÎ3)Z:È(jÿ\0R\'ÇM¹e›®ı:a5ÖÅÆö.ßù-9ì5¿\Zsšé«“Wö‘èÄÛœ !R¢©K»ëˆFÙ’ÄªÔUª[a­[ûÆÛx}ÿ\0ÏZ£Ã£2äåˆìEsi´|·Òym§PAìëÑÎ³¥w}	DôÌJñŸbv¢•Ú\r;«ï±õû\rwcÖöÅ¾3DĞ­ok¸É–µ©†ÜTë˜ÒóOhö¯-N-ĞØqÉÓ$RœI•\raFˆtªºSà­…ºô¿[üúyUn&·Œ¸3Ø$Hìq`ÅjXè‚R´4€®éå©Ù\ZGxÜÖyÙ)\r‘º³é¯T¿{éõ†˜Mÿ\0¥•+všM\n†D£.uŒ¹UÛe	ÖKÓ¨pÆbÒø‹’t­rvÓ7¥²†ØmE¬Ø6ò>>U2<YóÖÈÈÃË\\İöWœ×a÷4¶”6±ëKEZwGHúƒdöãa¡ûkHtı¾­+â™Ô[K[vºÎºÑÇ5î6‡»FIšgÛ1İÁÅ,…§(kjBòğ\"ª‚¤ê¶ :“¶ö©H—¦YBGjëÓ\r¥<†œúÁeÀË\Zú¦ÈRˆáQoRmƒ7—¥}k\0Ûíî ´U¨h=@óo†±¨ØiÃ•C%Ÿ_XÈ,«AÌan9_¬Úî¸â³Iïãî3æa<šçvÄîO—J¸Yì^9kˆyyRWÎÒF”«“\\†cÛÙJ–ãê;øWğï¥jkÍüê³tÄí¢tN±Ù•VµjwµöŒÖLšÎ±•£jW`]“šR‘¡1ÉÍğœ Bde\"æv±¨^lX[¯µğ¯…¹R´À•ˆË\\Têæ¶’„GZô«SiK!½hnÄ\0¥”êŞê®½¡A)N¬–d›[ê•¢û©†Ê¬¾{#¬È$=F­xh’@ß”6OLrb¿·\"Ti­/ŒØt@rÍÉ#ÌBé7>]ïO·ïªEa¹f—°˜îÆ[@%ô8¤,>>¸:PçE$‚G´-R\Zc¯»½³Q_[(Şğkü\'rªí|{=:×J\'ƒá±ê˜vMjĞOo2ÙŠÀš¥Róä®!VÛ„Şš¨‹É*œ\nP\nlıO…êzç4—{KP’¦twÙq×VRœ<Á£¼>¯‘{Ôbµ·öİ’–kÕ©2ƒ¼§ºF•‚@†¦j`Éé«¢\"étZò+$œNPÄld[,NLŠä—5méˆ¤êı!Ãú5_HÛö¿áãW	ƒWz,l=²RR,…¯RÙ¹*ÙIÕnè&Ä_ycÖôLV/ZjÍEÖ]³Ì[½„:áÖx°hrã6$_cî‚]vêø¯›†°(×&1XÕ&!Ä”!(ó\0¬¥É…ä¾«„\0@ğ7ªS5`ØQímáü·ÚxBC/¥ZZ)”µïA \rCT‰ÖÏ¨ŞÔÊú’lm}]ŞöeWNklàÚ:¡¯*‰Ü‚1×­éY£n‹œ”\"Tµag˜hÍÁ™(-1šrK%¡£±Ó{ùÕ|\\oÁcvh®¥†ô!n¡²\\>EKJº¤ĞUºÓ;)=ÙÍé+º6îŞIµÆïª·ëÑ»Sq“4ºf¢ šBd]çjåÉl<\'šË(Ğ8$P@Ô÷7‘hQ_`mïªÊ–î%®*#©n‹)¹\r#’«\\–ÊÚÊOy;½+ \\°üĞ–f¼l†ºuÂ«mi4Ûsn±%S8®µHàIö®‚ª²í…±è²Ô¿PlhÔh·&¥E nK„©Ü‹91Ä˜1Ê*R•§NÃÂ¢DLİ‡Í´Øøzù Ù±“q±\Z‰kv\0ø^ê¯á‰ïº½Bk=N–o»9Õ–…iö)cEÓA‹c*a (ËLR^A¯FÌÀD‘á” 7	¨–¢\0¨j\n<¯s;J\ZÜ‹tnÿ\0ÍêiõµÆX†Ú%¹rÛ¼òÒwV¯]¡Å¨„‚”î¯\0k!ÏŸêJÎä×=Ü± ÛÓß£^¶RC±ëZ\"(ûdÛ{Š~ÈKAİYxr%i,%&i¯Nƒ% 5ÑÕ	ÎI†[xÓ\nK… ‹õ&ıGóòªD¥r‘\Z9Øu\rRßL¥Içi¶ÊTÓKŒ•+uÔå¬£UŸ¬ıEzmoõİ\\êõëÒâšÔgËF]eLí¦È…Xô¬îOŒ¶Wæ>ŞÎ°b-x“”5@T4¾¸Â#ÛLL3»|KZ™Õ}·ş…GÀ°¥ºöäØ/l°ÿ\03Qyábu\0­:= RèXPòëV©0I|úYWAÿ\0ÖØ ıÛĞ[ÒÛ®ŸuuO\\µ¬šÚ€˜÷O“lÀ©]•zo1å˜VÚ$ï¹+pp(ŒeöÅ<:¾`Ôûf	QÓ%æcÉŒVTè\rrSÖÙ=©¢¢Æ»vu&Êëmª/]×ÖÉîËÖ.¤“±_“Ä”†°ê\\âk@ÓtW5²ÚşÁ–!¼á1[$\r’7E	Q¼=‰+*eË[¤ßERŒ`xV­)NûoV·Ñ„ªÆK2è:¬Ax2@ÔÙrSimMÛe_F¢”‘u\n‘7Æ×Õ{D-†¦àFm$ÔÍXĞJç_“VS\nÀEÙ{4°]ásÖg­xºšÚä/®(Ú\ng’$®1ÙĞ£+ñ‡ÉHB”.<úùUväÙ	+‰Ø¥´E÷oœa}E\\ÆËz€*J¬IQ		%@V<ŠXû°:§b¶Û#–Û[%¥0†íkˆîu`³#ºà×DV´mÃ3Ä¥UK|ÈÕñ”KÜ%¨£R4éİ‰RÈƒ\rÆ\"#×XÔıGóüš¤íx<^dÀ1:O/¼Q÷’«£ ÷XVÆÎ2ğJvWZÌ’ˆ±7ıQS-\'ªU#¿ô´Ùñ;FÕÔ~£©b:ícL,h¼5Æ>½‡aÊ[ºµ£\ZÅg;¶4Jb\n\nõK$•\'¦Ÿ \'B¶÷ë°Úô’Ş3>Kì±&G“º_`)‡KWßABùEaG½¯‘q±µªÆ:PµÔ¶Ûê	¥UĞ¬—ğÊ©õÊ–]0w5ÓšçU»Ü¸;ë¢“ÊtÚ^Sœ“$·•´hˆe58r!üqw°ò5÷ƒëy÷ĞÒyM)õj)m6²Gyv	7O´®k`>J©tâ”â”â”â”â”â”â”â”â•ğ¸6·»#9½Ñ\'$\n(Dà”…‰\0¿¼“)€,gúgT·\Zmä©)ROT¨ñjÒÓ}ëô\Zg½“İUœõ!¾znôÿ\0İ‡¢ñHÄ™	€G¶\Z@ú\\vú®Ÿ¥ä£“B¥‚I%-\")ËáÅš4XÀ)À,¶4Ûÿ\0JªÂÆ8]äa«…Ö‘©¾tt>ë­›İ1õ­	ehVÀ¦êÒS§q_Û¿¡h²úAµj6™+¿62‘uµaİKWM]ã§\\uƒ$…´E\\M,K‰“LÜ,Ó¨Ñ*wgA\"-¥HF•á9ùhSèâkzº¬ôÛnŸÏO\r¼ê×:,9”`º¬KRæ<§YÔ-­Õ>éÕµ«ºZCJV»zH¬1¶[¹z¹(+Wº‹u+³¤#Œ¹RÀlŒkË|:·I·\Z·&@lÖV–I\nF¶|‚tP™|­ÄÖà:GÒ+\\ÜâP/N&Ğ\nµmğ>\nüHëWuMÆÜ*RXJ,¤2ƒÍĞwíQÖú½^›iHBßÃjïú>§^ãz«©Úÿ\0®#Ü¦[»:·!‡9ìİÚß¨`6Í¶¡õí‰•e}vB½µ*UrJ†ÄiœƒÁœ\'–X°T%*x€tşZqmæ“$¸¬NMÔ€ÒZœc–7Ô¹Šf3jC„\'Ôs\0;¡eW‰¬mFØ\n§ïXÙË2³“\\j©]RŞHá±àÖf5º•<:VÄÄLç(Œ9É6+Ô¨¬+ıºçyÂ|\rQe‰eké¸ÿ\0Ò®œWÍr(cA	<…#Ø\0J‚ì&×æ‹h\nÊPë«/N»5ú¡İT¼¢ì“Ézªû¬æ/à®b2ù\"DHJM.F…‘:ƒ1K9«“àŸ#‚hÉÜ<rj\rÙ;şUH1œ6)»’c²ÙQmKq}ßšSu+àükkÆm‹Íg“k¢Ò§g6\Zd­2½¢`•Ïµ‘U§6;?©;¯e¹Öµ\0óprv9…½ÁpR”­«DaBø\"ÊFú@)µPÅNVÄÒ½8‡;rÛ6Ö ¤<Ú…ÁBK)aiIêBÛ:¼,vÍ4>‘í4/¨[ÎÖÄ:9¿V[ĞÙzs[\'¶.ªWò:òåºYX,ç÷\0©rN±‡?FT­¡Gª[\ZÇ•¢n)1~8ÇĞ†œoN¤‹~Íï÷Õ´àğ¥%ˆØ\\É\r¡62y-€°/Ëk”ä›™ß—â	½g¨•õ*‡Ò0:É—Eõíd©0÷ñµiÛEF§1À_K.tTÂ`±FÍ\ns‹J¤,¿RÂŒ¤`Á¥¤ôû‡”’tŞÖµ¬:ø«Ê«\Znm6¿£\'‡Bæ]Ğ€Ödê ¨v½QvÍ~¯—æÄŞ×Átı(Ï‹ªİYá°‘wFÉšÉH\0Ğ7%	ÈÊmƒpHÁ@õ|{à°ãã’ñ¯ó\"ß*™#Ï?˜KPğº¢^Ã§õö«YÑîœ=Sµ;^uz‚ÓzV~›^7¥ïr^ÎÚxkysÔNµ£½~L;\"†……%8œº…HWa¥gÚ`ß3ÔÄî{k;ëÛtûo½L3&0aø‡yCZ/\rh°óI“¥Cöz\ZÉ^n|Ê‹ê_¼t}¯dSí¼·gİWaÇïMbQJ¸9Ã#,´\'š½3{™Ùlq\ryØo)Õq‰ÄNraâ2ZƒiŞ÷Û{ïî«D¢„€UƒKõv\r¸\Z`¬Øí`‰>¥¿”(Ş¡ğtW#¤uö3tØ–¹Ët¡÷öó]õõ=RÈã¯õ¨W¹½Ø5Å4ßSHsC7!dfG@ÚGv°,P,	a†zĞYµ¤Üím®\Z¿‰`´$7&D%:Ca©WŒŸÔ„È‘¾’\077&«§©\rÓ\\Ö=¦š«MÑ-¶õê3plU]Ëi;\"¶j…Ñ°ÿ\0&\r{œç0A‚N-J$¬Ë„BgÄ‘Á:ÂÕ`0 äwht$÷@ßÆ cËê+äâmJV½)Jœsšç][ÈrÈ°÷ïkõ¨Ğª±fµzŸkƒÌ‰sbZö€>e´vc«ˆˆkD.„Š©™\Z­h\r08ñË€[Êï÷ä¼™ƒDH³¡6gÚ¹û÷Úª©%®ø.ğÒR<îA yo[\ZUğ—ÊÂ·©OP\r„mî¦l…r¦Wvˆ¿Ã%\rDÕ·{,ãp)“ÏéË3é§+‘¼©~Œ²–tMP²Œ†Â@˜ÀŒÓÅÉ+YR´[tùuS)¸3æ6—Ùv0o^™(sxº½+KÍi\0¡a>Ô~‘ÛºÍ§[ı`Ä4ccm^–ÙÃ.¹Àk¸«‰pøDv.ÛaØûíaÕ•ÁÍaÄ3\ZhÒV•ä§Z÷#<¤\n”¬Ájt¬EÈ¿[‹}\\ ®d––¸r#â(Öy‚Nµ”é*.¾¦¤\r…ÊzŸpM¬¨è]mÔ‹©¶´R›y¥´­s?ÆuÅLRœŸÇâNd”¬Æ˜Áç&ŒçWH’3—.H5ŒaT˜Ó¦r/=äî`›Õé0q<E\Z0çãFÔ=c.)çõ¢ÚİP.2épm;¨XX²V¾e¥Uœsh(-Á†ôM×«­’EjPº/k(˜ìäæÿ\0R4¡’#±\'°Ia®€‰9IC”dœÜÄiĞ\nÒæáõûp}sÙ°ëĞ¿ßW¨Ò±%É,4œCJÂŞ“‰-Ä¼­W*,i*SH>Ò­J\"ÊZÅ_×MMnz§#Ûw½ôO<ê³~Îç»¦rêò4ôùÊ2‹®jˆÈ^ŠW–t‘hñM˜D”ÌzKJX`Ì0Ó.S««¸X~&ğul¶±Õ”¬s„i\0/kÛr­ •w¶5sDBRJN˜’“§ °II$’ƒàYEØCŒvqØÇÆ9òªÒ”¡ \0\0\06\0yá^î**qJqJqJqJqJqJqJqJqJqJ ÿ\0Äk¡»ÁÓlªÊâæÖ§\\ßµÒP%®­Q¶£ÒÙp†óó÷àNlf(8¢Aßİ877”,gã´h;Õ,€â\nI!M÷~²´“ı¯ˆ«´îu	°=ëHöÎÎBšæé‹³µAU‹;- å^İwÖ¬Zï…G¬*¢¾q¯K!Vgå•¯¿#ò)¨±}øÀ¹Q¡H;ƒÒÿ\0ÜjòñrG#Cå),É˜¥†iĞ­K*HA)±ğRINõgĞ}B:áwßz[QúiMTk>Æ¼R¶F¨ìÕÀ¡çTİ¨yôn²./$›Æg6 ,‡\"Ó;¥JüÓ†äÃ‡½yL«ÒH°`7ëkïn«XtŞÕ‹Ëk	RÛd.lå¢ü¹±dh±Ô”*\\÷AkW´„ëBÛ=Ñ{—”Q§PE¤úõ€§éÅúzÑ¿Òºmg\\zˆW«*”ï‹eR\"_¦n‹W39.Fj&ØêÊMSê§Oê’P%zÊÕïû~5{u¬}]™Ä¢&zPóÊKİ°{‹F$SI±Ò–Ğ±p¹µ}õTE¯\"]0Öş–»iÔNÉƒIWÀ¤{¼37$p¸äÕˆ²İbÎ»Zòr´ƒLIéV\Z(‘¹ JÚ“B,@é¶ÿ\03ıçï¯¹’4bëOÈ™\'zJynDÃ9èe(AJĞ‘\Z•õui;Ø*¹	®ûì•c³ó\rW–Ü+:V4Äê8\r‚pÊ…%èå)n—È—Ç–B£Â<Øª_ÙDƒ\"XCY Ég¥T˜³Ò›êârĞØ@µ‰VÖ&Ä‡áS;&…ÃmÖ°FãÙ]äâÒ\ZÚ‡uÆ@”­7Ø©N{CI¿ZéÒ-›™ÙwE’Ôo¨øPÏD\\¬Ûç¤\ZÍˆlvAiCŠ­,=ş±‰X€s\\Ò»ûGµŠËÉi}A&Æ¡CJKšíy+kŸ?q¢üì67h· ¢´êğ.émïq½[Xi½Fİ¯\Z6jÖÚo¨fgûRÙ4ªCßÖ[3H“ÙlIt:[NÉÂe/Å\"ö¸-·ùasD¤&¥Î@>KréPğ¸ú»‹y^¯øŞ*ÆÈWÓnIPF•µ…B–‡.¡ì¬1\r”ÀZÂ¥(j-<\"ŞQGt%Ü3-)eo)¶cñ¹fÏD€µd\núİ‘¼˜âánAcL¹Ù¸Ÿ@ÅP?qƒJÀÃ²ZcºH½‰°6>çZ³³²úyÁxã¤.á·š‹Şıà•¸‘·ê“ãĞ×UÖÍf‚Rµ„ÿ\0è—´ö¥ÔÊÌà–yg´í¤	rTâsÚ¥¤«=ÈVª!`8Hbb;„¯¸Ÿ89jSy}|6©o0Ô…û9€+õC“P	ùº<…¬-mºšÃ2\rWƒéû†òí~Üô½ê\n\\Ös\Z¦5Ü(ãÛåÄÉ‹Ø‰œ\Zšl2Ô*ÃéÅ¸„´g8ä¢ÅÛÈ¿2Œ§\Zy+‘{\rÿ\0tßãSÕÙ2Ú™Ç#òõi_jy:ÁóRÖ«~ÙQ÷ïŞ¦Z»„·¾Ø?K.«Ôí$Òİ>¸‘SÛd­ÊQ2–(\"dÆmEgRƒT­Ä%	Ù$‘€üz¥B(ü|-÷ü«,Ë¸»¥&7oÄ[EÇ~ke²„ÚÚn[y$¯p«\0w½WÔ>0êó•½ V\'[ˆ$ëó“,f.EÙ\\Ì¯zC×d´Š[‡ÉŞf­ÙIŞ½Ù)\\€`—·e(0nr,rz¿ko¿Âß}\\±Üc±âÍ!xÎ)\ZI\r}ÓiUÆÉ/¢bƒr;ÅÕZİÿ\0t‘wê`G‘KWCúÇôØÛ&x£üê˜ÛúA=\r>(³i¯Œ˜!RS‰t8‚²Y)Æıc\rXÌÆ3ô6¢MÆß÷TDqçRÜ¨kéiZ—.$Âä¤4åô©…Idì{Á\\^½ò8Usµ4½wuí§Ar¦h-È$bP–ÂÒ•o5œ´G\'‘âÜğL…(®-$òÑ*¸BWÖ1ç‘§D ä9øTQ°øxÖ8î—•\0†±,)&çµ/˜ÛnÖ[xs«ºGG™\n~Šß#º){ÁbšÛ®ıXí\rk>´¶+×HÆ¡ïaHæÈÅ¡®ó$Ò8ÍróØ4­2\"htoL‘k3|¥RP„£É yõIZV\rî<‡ß#øÕŞ[8â\\i1å@šŸS!›­´ÒW-NÛúÖ”»õ½ë·Ûz_µn©ãê©Ğî¡•£uC†Ç«m!rosŠ9K`*ß²ËeÙ4\räz%²”’B°-èZP£RhÖ	\"Á.SÌæY \r¿…ïçTsœ2z#H†ìê·hq%rÍI¿|7=)l÷”£J¬9—¨C¯õÖ«/C§\ZĞ®ñ¹¨›¢Ú»ì;÷¨n°ZV•Ÿ	«+ıw¨$·nh©]kˆ¦ïCÖü§fVÀŸĞvDÕGš„8<%Æ­\'È[Ş»UÚ<ŒS‰Ê‹\'´·¤il!§${<PA•HJHQîl®úU{Õsë/æ^»½~O¦îOo´dbÂz·6+N¤†ø²P¯å¨ª iP ÎJE‡•¿H%a@Â¥×h†x°ü¸m¥xí÷û¿\Z•‰¸,Ë-¸G-E\ZG³¥&î*ß¶«xZ¿Lì~˜ı¹ETµçŠSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠV.»Ú\'r\nbÛa«T²#³^ë9ÛEv®JGº¥œ¹E•\"Šü›¾=Da\\22¤şâp<sêM”+â‰µ>ÒX¥?«hZõÏRzSµ×[Ñ[SQÛ:öºº‹9C+8ÜUNf/*²£¶’?»É˜ÂòZ€|\rcI˜Œ\n”7û‚±Ê…oâO˜şª‡	Âòóêue3±)\n#ó>ZÒ»ß`¾Ô“„ƒºCL¸âÒ‚EÍcÉ6õ¥±Y6\rvûìfİlšZÔ=ŒøwJ¨ÓÕq¥oÕğšÛ\\ãéVËÄ å)pC°§$	©Í*‚ı§€Fp¾«`|>ÿ\0*È\"b|ö\\d?\rYqQLsÚçïçÌCŠk`BJ\Z`·¿N•¾ÿ\0éÏ\ZÚÇJ†cÓƒR\'Sİ‡uĞ4Œ©qÃÔqÒˆ¢#cZëõHÈ„q)\rsDqÍË6BR%n@Oë+N^TB‚Ô øï÷Ş¬˜‡hÔeÍˆ„Ydµ\'”­2İÂLT+p\\¬%z‡B5W|+X£·tÍ¢4UËËØfYºÓ¹öşõAÓ¯Z[ò¨HbßÅ…0&åÌ™4Ö¼G‚cKJM‰À\"Ï$~ ¡XJˆ¸¸;ì>ŞŸm]ÚÄæÎCÑbÊ\'Ö\"S10ÈG–µ€,Ã3e+i	ÙJÔáßõÍ¯×!wT?R`µ«Dûlº\rê;Ü\Z\"ÆÎ÷% ê5»·}MãíÄ¶¹Iİ\Zİ‚\\V˜HÕŒ¿#……&Ã.AY¾’‘Ò×¸òò¤Œ©ŠbÍµ…²RöcÄu”ª×R…È\0ï`¢Iè<¢¼{ª—Mš-–onê#Õ®Ôi“Øv]¨âÑ®\Z»[k·í¯(>g<_‰ÈxDŞ­ÍJ…	‘	FIGƒ…‚qò,æ¥Nõùsğ_•‚Él}!„G7Sp ¥ô¤ø÷¤¡ğl®ŠmÍüD%İZúbDe’H>§õ\Z¶%³§tOÓ™5½ÔfÓ„¬š<6·™¹ŞNmjáä¸ò”RR†|’œ¢“ƒ,8Æ)»®\\¤û´\"Şáıõ[‰FÁäº§Ìs˜;íÀ‡€ís‹±ò¬a!ë-§+W–ôÉÒ\"½s‘\'N¡¹’ÔÜM—°¤4ª<\'¨A‡•‹B¨%0„g”Yà$ÓŒÈqÈ‹Gm%^vÖ¿ï	ş|jĞœ‡®„ó\\Ì)#N¤â%ƒñ·,:tµu<u›¢½nÿ\0ê•Õ|Œä97nÎ¦ÈŠÇÀ|¼¼ßÎCóÉ@H¾ûµøïS•„ğİiÒNgÓáş9{ÿ\0Ïø×pIÖGG]Ğ*i±z1Òoín%ûW&ö]•¼Q·¯J,ùd…-nãTQ˜ï€‹±XòÆÛ¾1D¤6àİKù)Cû*ªwp./nfa·…ñ\'×o-¹é¿óµg¦²=-ˆLšE¢ÛËL…0\n%)´\'PëÃÙ7@0Y BÒé!@Q`\0qŒ\0!/ÄÆ0üvä=˜¦Á:ˆ¿µ¯§ı³²ªğü+EWæÙƒ„RDq z‹“#í)¿IºªÇHJ¥…ª#LmwYıLhN±sŠHş&V•orwq1éÔñFäX– *r•]“ç*4ãLÌ4Bõ+QÓ¨—•U>Ì¹IKMãX!raGÔø½¬¥˜…IÕîq6÷u©KW\\:›56Á]Cõhéï}ºÜvƒå×:„õ;Ô8[Sì¦zòÊ…w¿Ÿqï§&Â´i’§HÕ¥Á?ÙÁ÷‹‰Å)Dn€gãöU—ÊØÜLKœäs\r*LWÓå$[BÛÎ¨8N÷RlTnlo]¦#¨7±—sÆÄ6R\rÿ\0À@W±öf–…›Æcf\Z¬Æ™J—·Û©ui1ZÎ…ÔÕˆF°†„å¬Âp&F3ÕÄ êJoíòş}ÕnÊÊo)(‹aÑTÂ­Û1~r”ÛKN´ám±ce6Ş“`I+ÆîùMYiÇµïXÉuÅî9mŞ2˜_^Mgş¾ç—Y™p~®lR¶ïdı\"w1r×€½À¢BI$…bîå§O5â]N£ğ°øUTábk!ÄEÄ$>‚ê;#Â&&…9~ÿ\0%Äm§C- ‹tNÆ²\r =¦/È¯©öátó»®ÙÅãdÔÓíd—clzh«ªJÀøÑ@	¸¶£2öÄnæ¸0GFBƒ„âk‚|)\'Ğ–Î”¤í~›_qóªæ¥ÉÃÌ»)Q¹Lt&ú¬t!3œKzÈ”¦bî¬ï]m|³sµVË¹w{KµÃ¨n×ò›¢/ür£A\nO} ­ªù\Zæ56Ô‹\\æKıÄ}´ˆq\0#óÎå!Á+~—’\r	™‰`iğ=*D˜˜[Œ‡bL7”Şó\")OG¯´ôu	‰hø·›îfÖ¾jè‘®\Z±Xìíÿ\0ptø©.xæœÜZñR¸©l\Zqrş,©–8È›!3µ’‘#³”_\nËRûûÆâ	hökri¸\'ã»6‘µS}œ5zİ¤”¡ä8—P–ÔOqN%)ÔâÍ•b—Ş5³W$TÊqJqJqJqJqJqJqJqJqJqJqJqJñÅ+[~¼0ÊÚUqôğN]FÈ/³göòÆ­²“‚	§îTD^KÇØw¿\"Íw$g¨e|G“ûƒÍvf\Zì¦\Z4ËlæEÉÚÿ\0Ãßò¨›ç•hi2^[¾¬Äˆ÷!ÉHQ±O4Ü  éQ%*ıÕoT“¶}P´²¾¢¼všåŞ&v’>ˆ§Ltß¦=;Ö#p©LRA((£äM\Z\0y²âÔ›P‚<ø!^ÿ\0³c¾ö«š²ãø|Lˆ8JT¥¸S…½=#U‚¢ğÔ´‹)A,(¢ª.C×o`aˆ#ú;®ú§Óò:âIÍÆÈ(º¡±úğriÉa-92[®…ÎT„‡ÔZä`ñåœã8Ç#PÔ›ß¿áğ©¡ü¹Bj\0œê¤IÅrRÛWK²`ZŞ*÷Şª¾èÚM˜ØÅşÿ\0Ø+ªé8É…•dÙ’éj21œ÷şÎØî¨ÄÅc?=‚YAÆ?@öÇÇ ¾£cQ¹™q¥ ¡©†îO)€–Q¿¹°¸HÂ°\n$¿öEPsóŸL!ßŸ÷²c’Ô,jÆ·\\nµ)gö‰?=ëîLg qg’U¼ŠˆiŒòBT Èsöÿ\0{?®?~Gr?•òÂ¾aÿ\0NßÓ??§!&õòÕìÆíÈo_ióûÿ\0Ëü¸¥yïû~ŸÓã9ı¾ëÈN”¯·oÛôı1Ï—Ú•ãõïóŸëßãŸRmÖ•ü˜Qf‡ÄÂÀn3óà0aÎâÈEŸüò=\"‚ééµ¬v÷t¬…[Z6•@øD’Ÿ²gµl‰6BaUÜÊA	p\0‹ÏªaK„ùÏqå,‹çøäÔ§Vİ*ëÆ˜l§´-A]Rá+Oû)]À«h§züu ®ã&W¶ƒÜz±n=»k¸Õû=ÎÒè—!È=#ß–{wlà8ÏÛë,?ç·|gíÂ|7ó¯ÌÃ§´*g…jK¨G*FşÖ…§ÕŞ-¨ÜV­}XzjH\'k\ZC[lJ\rˆŠ¶»³0Û:8î\'\\OE#<“_š_5Æt™Å¹bá&Lc‚T,ùÂ“–a‹i`;¸¢”î@ùxù;ûê¥P N’Ù‡9äÜrû/¦DA{ê%Ò±öE‹]|oS²ìK¸ãÌWÃzİ(»õ}n÷·»³ÓêRë®{!$ÕJJdµ+ÍŸÓ¤.Daô§±Ø‘øğ·	Úp1#@MÉeóë[t½Èù|¾ÊµÈÃga¡Qİ†ì$/bô9\\Ü5ëêïò:[^¥Ûc¨j:·”kDÚÜØÜŞÌ{B)5 nLJ6ô-©ˆ	(Q¡Hœ!,¢J(!E€!\0\0„!Æ1Œr˜ŞõJ‘n–Ûjûø¯´â”â”â”â”â”â”â”â”â”â”â”â”â•@_‰Ò?yèÕ³ËŸ#ìKcÔÛÄqk³bUê£o&\\Lm{b9@D$Ê½¢•)}br2Iä÷È\rs÷š¦¥«ğ5!/ºŞİàâ4R¢têoãó¯Î­³QXV¶5®ÑÔƒ7¢T2‹mH2Ë\Z¤¡?Ò/#ÏÎåÛùÌr¸ñ‰Ã”ãb\"µ£r~ªˆûkÙ<·ù1òv3—àËs1MC²á³%Ô7µ\0^i+Ò’MÎ’£¹ëÖ¾¬éÓFDınêç9ï6¢Îr,gíÈ~OëßüyN= q?ù“dşòªáÿ\0²Ï*\'ü¥•ãÖ\"?-TÎœ5ãó«–Œd~ykMcí÷œ°qß?®sœã¿&µÇÜMJîÀ\nQğûªÿ\0%ÖO\ry¢CA\"åjŠØ\0\rî¥XyøW=JpÈ’\"”” àÂÎNÒYÀñß¶I0ìg®1ÿ\0>V¹Æüu?ü2÷¬Nÿ\0 kOäàáiîôĞP?YPGİÚAÛÊ½„ê\"£<Xæ*ÉX	†2*\rÉy3”nqÛ=ûg?·Ç$9Ç|^3`»…”…x’ /ãÔ[ßSa~LÜŠ­ÄÂÏ\rËånàe¨ï,ëRwøW¸İ6Eös•Boıë9ÎŸé’ş¿¿%Ãü°›öy/ñ¾Õ\\ïä²Â,y¥Ëu<Èÿ\0sk×9IŸâzÀƒœãèAÇò¿OœŞLÿ\09\Zâñÿ\0xğş5$şK5Ä“ı,Xï^ãè“ä9»×N²5™k“†V­Ï.v\\^„¢l)8JLşĞµÄ÷!æ,äÂ²” \0;xgÈ…øÇ7§sS\\VÅ›ó&(2£ÆYFöKÄ$«÷·®*ôÀô^>‹°#HŠ}0Ô¦[|Èı˜¥m ¨ê:Õqµ€®ış‡±Ì›’³;~ìÿ\0 nmsœg·|ƒçÇöÿ\0¯= W¢vUüJW^…´}kÉ“ÇüÃÔ@càV¯ï\"½¿èoÀqã7~ˆÂ6Ö°şŸ>?9ÏoñøÇ!_¢VYÕÿ\0Hÿ\0ºG÷Ô±é_xqÇÃQş~5é;OcÁÏÙ;z~ß?Llí<÷ÇoŸœãã”Îz%å‘ÿ\0Ää‹ÿ\0Ñ ïöÔÄzBã_ó—yB½Z~ÈÒ:¹lõÌ‚eoo1ÆÚÛê¯sbj)áØ²‰À¼¼	 ò„#Ùäbô±œ™Œ‡–×ı2lLMˆ®c2™)qm1ÊoR’ÑïŞûSW8œqÌâÈ|aÍr£„­V{\0+Ètù˜aÿ\0ñÃ¿ÏadXioÈAı¾îâıÿ\0_Wÿ\0‚f\0IÓŠÈÿ\0i”n¾uCşx¨ÿ\0Ü#Ş¯û«ûŸ4cï:vÆÛïËBÙóÏ`øçÏü»şøäÑCÃ|ıdùTáé‹ÑŒüyÎ}Ûl+ÚNš·Aç‹€^Eœ9gKcû¢Çó?^İş;|çôäà“‡¤íŒ;¿‰ˆÙ·ş:–¿HlM	7Ã÷úûßuZ/Fm/¬ukÑh’•ªİ†Ùğí‚°Ü¢’v`Êªq¥ÕT Nˆ\n4E¸3£rGrJV\'Â¢ó Ìs§øvÏ\rq±	¹&]ã4÷8¶\ZöÔ FO•ng™y÷yÇ[1’‡¹J`8¥¡`$í°·Etğßc_§ÿ\04íl\ZqJqJqJqJqJqJqJqJqJqJqJqJqJqJ¡ÄĞw¥Ñ›jûçIÙï›Â>gl_îşœ”÷è•ğ?©ñEä·ş±Ú¨Æµ2gAkÈ´¦´…E.ƒ\Z×‹6\'†ÔÈÒOU¤)º$Á\'•.%OåÖ‘dÌ.9ÜD\ZQëS’Ö°Ô\rÇ)Rg0ğßÉ˜æ!9•Ëæ¹ÊiÏV’£e%_Yw#cÖõîG¥rô‰Ê\\0ÊêÉér\Zœ>Ø†\'!Ù<ÔGmHŒ¤-i§7R—s«ØØÖJÙn!­Võ§Vœl*ÁˆW1*ÔŞ£“·Gã³Ê.ëµSÓp«è(@°ÿ\0|‘á@\n‘¢A“Ó\"+^ŒóÑ©M‘Ù3—0ì¯‰:®Òâ“Ù¤Íb+mI{³jÎ¢\\UìØ¹=Òz^µVWü§R‘•#GÄ²Óòq¶ìÄ™iu-@YÙ-ºçõº²’§PÚN›ª×õÍÖššå™n;µâ‚—½k-[‡HhÖµ–[tSoÖÙÇCÏÅkf·j‰#ø/ÇZ&PÜºZJ–ÕÙ$ÒË^F½Ìâ¯àØF‚øDÌnØƒ¹Æ¢¼œqBj. Éqlh“¬6éÖ\r®´ƒ¦ÕÌ¼hô¼Ï¼rI=+ÁpxÎr§aØ\\§ÃÎ¤¢íÈçYµ¾ò›QB@îéR€eM¿è¾•º/@ÖÔİ1`&¿äÔ’\Zl½A˜/‚Ô35/H6‚R\"ÀÑÔêQtaè•­Ï‹Š\\×ÔO\nN\0©7Ra¼:ÌXëÏcÒ±\\n>!ì˜–„bÏÂbNcL‚†Ÿ.İhj4æ\\jJÂ\n¥„ìæ‡XÀä¶ìfå„?»½ö_~#‰Š½i%W*R¹—²¶JHò‡Ö¾²Ä,jî	s%«…!¥.éÛÍu­ÛYÆjŠõº¶*QÌCT\nb¨a¾Î7¤¸è2Û•\rÒF»)Dù,8Œ˜îl#ˆØ¸˜Æ&ARò„Ìi™FÃÛõŠ~+^O6f$\0­í‡|ÚÖµd™/3æ^æöqåA|¸dÇ\'“#M—Øk~g1$ -[8 `w¨W²\Z‰´º‹±gV{±\"Õ-˜šœ‘?VS£Îet²O®‘Ù&ã1·„¿ı	z¡«{^•)ãBÂôŠ,*9uÈRÏy›³E˜°ÚbC¤Èh69‹½™”8Pä…%•ëB.E…ÍÈ¯E%~SÂÆQsµei\rc<’ÜyßJğÅI¶nómóÈ·’¶õ7ëY7SDmŠMŠt÷°+K®°ª;N®c\nZŠÌ&HÈ™ŞQ\ZksróU“Yğ °d*Í$G!1+¢r@Yâñè|{†Ù^x¦?­å›¬ê*I» ù|kšxé³é9œø›…±\"dpµKm\'i-7l©c›Ì[»–ÒN£}!Ck‹Šv,Cc\0ÅÜ\'ìTÀxš€\"aÈ&—vÏÎ~ûã§\'ú 6´fô\0v¤4›õ>°Xıƒ{Öùü¬.¥îàjQJµµ9û¶°´\rl+RÓ²’¸#Â³|€3{g¨,dX(>C/#ùñ?Nÿ\0õíÏ|Ö §Ä×å¾ê)ğ·…¯_ß–|{ç8ûsÛÀ>^ qâoßõÇ>wmıÿ\0@ÏE#àk.U´éz8KÛé*rÉ¹s_9£e˜›]DÜ¤ˆÜÑ¸¥n	1‚±ë šAÁK7°ÀPÆ0ÖX×¸y—ñUA›<3!²¦”Û›mpuh¶ŸÚøŠË¢äìfTDº³¨ºCm8ñÓ{w¹HRSî…{ªì«î’÷\\Ë¦VÖ¼K)·ÖÍ¡)D×Vk9¦L@]ı™¼¥bDJÅæ™|éS»ûQiÎô½Â6ævRäœƒ³—Û—ÆHøÄEs\"BZ\Zl‹éäÚÏ)#Æ÷*÷×Cå¬€ÚxdôwZ!÷K)|¥¥×{¶	Sd÷>¢@*YönMS\rµ­{AB¬›¯_nª’\nÒr%3:íıª:Ø{¹¸!¹ï„dúêNÎ\n ŒFšgØX3Î¸ÂøßÃ<mILyã˜«ÙmÄ¬û´Ø’oã\\øœ˜›{’\ZsO‚İeæEÀ¾ëq´¡;lMö¬$AÀ58Gà>ê$Ìy%ˆ!0>Ù\0±Œã=³øÎ1œgã8Æyµ\Zy ¤…»ïÓ¯ÛøÖ ãjmÕMÒt$Zão\rˆÛßz÷ãÌ>]1‚>8Çİwıÿ\0_»·ïÛ¨_}moíü?\Z·.€wı÷;ßî«=éÿ\0®¦X},Ò¢÷d\"Î0!{¾Ğç9íúó€=)ÒÚ·ÿ\0/`ã_ã]iÀWT¬³+VåSJ¯`?«@µ~‡¼åŠŞ´â”â”â”â”â”â”â”â”â”â”â”â”â”â•@‰ÜÜÑ»cûÿ\0ï%Ta}¿âò¹™sÛşÜ“#ôıÓøU\\óæÖ#ñ­š@XZ	0²Í(ÖFâÌ(aÁ… \0ƒ|d9ÇëŒã¶|sÎùN¸Æ\"émE*ç8B²…œ$X…~²òÄS2>ÃÍ6ûNaPĞã.¤)µ¥QZJÂ’|Ç¯Ò¥Ş®ì¢ŠfVsÕ!‘Ou¥v´l³†ìDÃKÙœ·f¢¥Íh[3mb$-¥yÚc«.w–×Â±9I™ƒ¢s	Y~wÒ,ºÑ³²ÚLYQÌUş¹Wh¸Õqtß­y)é«è§ƒdX+ÌX\nRÄ)¯7T—QŸqĞâek³:“ÊïnÚ–‹SufÏ»Vv~«¬³P/¶ÇMÖöh¾L–	\\mä÷eşV†Ù•ã4sFL‚—}gÏ\nñrËsÂù ­\Zì<áÒxw€Bá;‡¹\'L’ŸÌï¶ãÎ=9¤Äu3À’ K‹.é+B’§İ#Iµy¬ìŞ×ŠëåòÕÙßŠ…§B]ÿ\0K¥J%n<­JHRnÊ•m;\n»=TÛ´å’~šEÑµß“é¥meo+…ï-%7 †UrU‹õ\"«bÊ/ËH-çF†¦ˆÙ©œ¦öÉÂ/È1F5·	8‰‡gNÉÍ¯ğ‰Y	Êø~„ú–±T)Äa¸‹L)>±ØÑ4¡å)*¿fÕ¤ÔÉQLgB»æ:¬=¤-qÔ¤ó\Z\nM¬¦7-ß½uuÚÕ¤©`3Â#W¬r³±âºƒ³œÊzXV1eXpYİ”69Êˆ<)6‘Í&‘±[[¢ìmSEj0ß‡å^u”#³´ràÆâÍ‚©Ì+ˆÊŒ–äbbL$!®ZÒ„—\n\n’Ø[—\'nù1ì³?`Òå›l!pI¹BÊÔ€wRƒaj)úÅÂ»[»jÑ·÷ÊÀµ¥«íèõ‡\'¯\\ä­[0é²ëœÓC$UD1ç`›‘@ìš»QÑ»\'=PÏM\ZaCüú­zºqÃ‰“N;páx~–3<8,1®<˜æl¨¥L0Â”Šş°bÈd›\"ãÄWQğÏÑ£Ìœ=Ä³N;%È8XKu„-—¥Èß–†Š´ó´9İÖAA\n)@½í|·×R-¤ú]ÓúÉ[NèİÆÙõ_TU”!¥µ‚éÕS¢  fÔŸ9½&XÚ„˜²qäF}EÕI%$ àãDNõÍÙ§À¡H[®6T½\r^åWöş5¤¸CèıÄ.\'fèLGÃŞ	m‡%tCIÕu+˜Ñ€ØQ+î&âÀÜ¤>ï6ğ3U5C\0Tp[¯!äÿ\0ƒˆúÄÆ*1ÛäYÈ‡œvÇl‹ã¶>9côI•ÛóÏ?HN¼V\nô\0]Ø=k³ÿ\0*FŞTávZÃ›%Æ áòX$©ÎTrŞ£«~õµw·ó©1jÔ¸ƒŒ„X/şöLPÿ\0—õş¼÷¥agÀİ_~aõ‡p-}íå{í^äÙÁ~~ÏˆÃØÌ0gÏç!ïœg®>;NÜ‰*m¾÷»q_N>7Ò‘º}ß\ZÎšíiÜt¤‚Ñ¢¬—zºÀ²¼T¥´€.@±¬$àÄ&¥a\Z7¦—¢HŒMÊ‰8!8ğ(Iè*,Lq«&åŒÁ“¦Iœß®Ö¸Ò/!@5ûIUş[Z¶‡s®bÀqÖ#E)[R½ÀTÓ·?¥î÷›Z\0);í_¡†ÆR°{2²×»bë¨ã;%a°¶+o©?87 ”I]Šm,ÇÜÅØ%\0NjŒ(ËQJÆÖ’_d¸R\"ÇÛÌ°Ãªd¸–Üå\'b°…iMú]]ó®äC2]\Z­×½mCY·R”›)a>*·«G^ªW^ÎÛ»µ~Vû=(Vµ·\\®DBš¬™ÊTÇXÄ k“&~ƒÎ¢Æ_PyweZõ/YhŒ¤£d,®wÇ£^JÊÑ„â©c›ˆ(©*qŞğh§ê¶:\rüH½År\Z³d8špä¸–!jï6œ|÷†§\\#V‹„î÷ªö{ùøcF`]ÅœãÔıJÏ—|wï÷g?Ó8ïÛFsûÕÖ¹ñHå›mÔôéjû–nN/Ë¶B<Œ_wB¾?§o·?çÉí $6©_k~°ş~uf!Iúâúiš_†B*\'uóŒ`Ï#CŒ wõJùñÇacÇúãüyçç¥H¾xlù@gûj®»àü—ÿ\0ªWö_¡Ç9V·Í8¥8¥8¥8¥8¥8¥8¥8¥8¥8¥8¥8¥8¥8¥kÏø¢ÔàqYŸ½²(T¸û²wş+¶ªÇ~ß·òûvÿ\0ëÉ2vŒáòAª¸ó™ÿ\0ZßöÅiÍÜ,ìıÃ†¦ïÿ\0ìŒÏïÏ;\'Û^ôÎÿ\0mUúĞÊkZr¦åô|!¿ÿ\0LŞÿ\0u}jÉ!BAQ>å*ä!€˜V~˜_ac¿éßÀƒğ ç3‰øTùX> Ô†”P¦Ö\r÷ß~‡ÌxZ¥æ¼Íù~NˆGKğæ4Zy¥ì»÷’~ªÒ«)\nä®Êğ«¢¬ØúúÎµ¦q}»k…ĞÈµci6ätƒ.íT!dMÆS‚\"Ê’Ã˜˜âk\']€¬|slDƒiÎT˜\\ØOÌJ’ãJ^ˆÎcX|h¯_—Œú±¡.ªÎ‡\Z+q\r¦ÚPà$ƒoÎWx]ÿ\0¼W•‚-äZV¶µ­´¨´òôÔµÛSÊIJ]Òl«{š–pèLö]\\LZbÌóÇ‹sH¦·VşM5EbMöÎ»1J&Û†‰¨Ë9rÕ¦ÃÛË‘¦P &Êˆ»yyXän57˜däÌÆîôØIÅ³D9“²˜mµ\0+‡hüí-‰«yn4âÁRÂÕt€/«HT–ûQæ)jXbYq¤¶«£Rí²{¤‡“Ëêò”¢»º–\\mME´qE³Kz½›	ÚUÑá\\)¡æ¶®­Õ°ñÇg\r>˜İŠ€§}}IF\"‘²™Tê¡W/pVÅáò¤à““1˜ØL‰r 88 -³21\Z)Ã’¤“©H<ÄŞéqCÙºËxq–ÿ\0¦ÙçÂGé‰ÆŒËH\'SŒ—.¥%Û©ê:ôtõ;^ªÄ-MhÛe-½ÒÑFÿ\0lG¶)2@`¤å&C`!ÀqÛãã˜h›-r•#˜®j”TW¬ëº÷#¯óÒ¿LC/`ñ°60ÕBap˜i¶PÁmµ2i#”°Qµ¯Ó®ıo_Òd)Ò{th‘·“‘E§D:Pw{ˆ~ı±È‘*SšZÖN÷R‰üw¨ á8^Àb±$›\"3-0½T–’›Ú°&Ê9ˆÖdü‹?ÆøØ±ãşğÀÒn;øÅ÷vşŸ¯øó²½¿åsõ”í×ÿ\0•¹ÍY+óÑˆå_øøÖ|óEøñòsÛïİó‘gôÎOüsß2{çÜkòÒFšş‹ÀNÎÜÁÎøõØíãîxşÿ\0Ëç?áü¿ÙQØë?}rH%Á­®p9	‘I34%Fşæ÷³S*TØImÎ \Z|šˆ–i€5]Ë4s‡gŒ£;`ÂïºË%öt²l¥¡½WoÜ}Íë(ÊY‰YKí©Ü…%·”;ì%Å‹%ÓmÎ/\Zà—(^îì÷ ’¼È¦9Cˆ%3ƒËŒšg&v(ßY#ÃôÉÈb^j¢Œûˆ;Öµì$Á\0q‰ønIÊx^0Ö¡°\"éÒ¦TÒMº¸HÔ¥ß}WØÕDÜéšñ|ké%Iu¹\0İ·›ym†Ïê6Ş­	jİİ6Øe2‹2Ëœª›ZV\\Æ|*Dñ/<·I Úà‰DÂ[¼  …Sª‚S„ Vä%}¹$j£BA}¨rFBÃ²/jj&4•‡[Œ½ÒÃŸX!]H;íQæìç#5¢;¯°…Ëa%º®›Xj/}îæ¾,÷Æ|†#p/ïã\0Èƒ÷wñÏéñÿ\0Íß¾~9Ü(ûü~5ƒ„¤mµ¯ò6#ì¯o–D2üƒøÆü¿¸±d?f€ÿ\0ç=ş^}R÷ÜáPÜ[õ¿‡ğ«+èæhÖg§Y@B2¨=ÈÉ¿~sŒàMOÃû?íÛíœş¼óûÒ¯lô×¾ÿ\0¸åuÏ\0Gù/ ÿ\0úµe5ú$ó–k|W)N)N)N)N)N)N)N)N)N)N)N)N)N)Zè~)áà= ­\0|ÿ\0:â ŠÇlöÎ3üELgÿ\0×’%›9û‹şÉªÜ5:±?×5ÿ\0˜šÒ¬Ã;oôÂñcü±œ(1ãŒc?§üùç|½å»şµÏí\ZıfåÀNWƒáhPíğìí×akiZì°¤ˆR˜a«(²‚ÏTyÊ„‰£D=J•$$F˜³U,P0\'LI†‹å~âŸDxÍ-Å“¸Héoä=æ­¹ç=å>eiÎ3%ˆX|v–êŞ}`-±¨6pVâÍ‚J‰Ú¦-\0‚*Õ%İ}=ØVı×e¢Ñ\\ĞÒ\Zn› Ï¹n9Lz Ü®Í™*t{k@¿èâ(ÕF\'Vœáú&VB¬›Ì9Wr¿²6)—_Àp|#r’3ÄÓ˜Må·Êe’¡Îp¤MŠS_ŸH5Fô‰ÎRñ¶Â°fé6Ö™å¦I\rêKg»ÌN•”«WÕ·³q™bVÅfŠŒµå•¦ç=Tl×\Z“\\7_âu:»3§É·™0d»„i›K-céí/1:ÈH5jõ„öõ£(ÿ\0U8lğÌiŒìû¿AÂšö„M‚Ï[âC®æI0ÕôbÖXK:[@i	AJ’w7Ò¯¯f\nOjÁüÚÔ„¼?Mû—~ë*7\Zd\'® 1&ø¾6á~³êmµ\n·\"ª×8íùjU5×¡ŒH(„íÌiİPa2’’%LìØ×–cŒé½Gvd.J£Æ{\\øC”sláÎ1ˆKËÑ2ö/ŠÏúBZ#>^úAÛhSëUÕë^q½K._ã]èÉÅ,ŸÂ/aS³Ñò#©’#ĞZÖb­Z”óAÂ„4À_}á¡{\\ŞÀÔ%Buä§Z‰I+Q)$³’¬Jqj©  4•ç!3ıqaGrÅµ¡M©\n …{›Şâ¿D0f@Å!\"DwÚ}‡BVÓ¬8‡ZsP¸)R\n‡Kt;_zöüşı³œOœygúcøUaUA\Zû§ªQÇdÅÙ‚ª|şû•¬aDİËFxøã÷Ç—ïóóv—¡½noş±öëÚ¼gü®IÊ/¼b>èÅH\0±>µ²áRrŸd\0Y2¨‚Õ¬ÁÊr—!1ÙïˆÅŒc?ŞÇÛŒçñ}+„«1U)+Ip±ÌO87¹Ô[\n+µ…úoá_—Å1%¸*|0£\'O2İUĞoäkøZ»Úx$¡\ZÈºY;J¨3—Q-ª¦3CĞFb–\\iõ=d¶JÌì¬Áe+j…@Ã‚…¥2ÛÊPâY&\'<ô¿JNŒ©˜ñ,=3±oèáubDŒ¢ûÎ0®[ˆŒ;ÚV\nJº\\uğ­‹„¹‘ÜKŒâ[aSˆïº²–Â–j;ö²ÁGŠvØÑs&ÿ\0l@î+²#^8ÖÏvì7¤9•âã¬g,	‘\nšÎ\\ªûSU§š¯P±gƒ¼GôÓ2ò1àAÃó¤$eŒ­‹`Yt¸Ş$ÔLKé3¥Ü>:º­ ƒg{ Zà›Ú²ì3„xL¬k‡*{dÀÚÇ4%.¡:¹èuJúİĞP\0ñµ¯q]aÌÈ:\n‹e®‘«Eyuq°ÊåLÑñ¾Ò!ôåa¼UfÁLp²†\Z\"	)!&a^–LÀ„Ù´ş$ñ%9AËÉÃ ŒDÈ\\Õ8£,½k­:z%ïxuøV9‡ä,½?$MÅÓˆjz4…°¸j)B‚	üİÖõÆŸÒÚó®Ì¹\rzGåäìó×%S%3³%5)G€ª`«˜ãßS¬,DV/‘¹ª˜®-[j6”¨‚$Æ\0Î3”ç|wŠL“³T\\Ka¬+mNá®FZ•&{b9q²u*É+p„ƒmê	|?ÂØËdèØ¬u¹Š?Èq—‘–…¥ûVı@’,w°#©®LêıİM‡Šö*¯.\'G„u7ä•ô¬‰L¦<õ-º\0¨¥R‡ÂPó\n%ËJkwóÁ(‘(Ï‘Æ“ØÂÊ Ê’˜\\\rÈÎ˜ş\'|¥ÅZã·.§ë¨›^ÛøÔìÉÂlO	Íñp8o‰/ImOŞãV\Z»»X\rĞ§Âº¢^ÊØfmJ!¯Ğ)”†3g=#ŒNbÏ\'Ç#K’hÒ˜qkœP2Qæ£ÃÈ‘<ŞS9åüİ•¢bQİÓ\ZjyŒŠZQ¹IÔ¤îo°I&Ş€ã¹zv\r‹ºÊ™ºš-‚î€z• n\rY\'FÓrgZİ+ÔÇ’mÛL™Ø!Æƒ£ƒÆ;ã?·||Ïœ]éXoŸÿ\0«£ÿ\0æ8tÏ\0›\rå}µ[üi?Æ¿E.rÍo*qJqJqJqJqJqJqJqJqJqJqJqJqJqJ×ñS é`öÿ\0~ğ úãüzP¿\\ÿ\0—$Iÿ\06s÷ı“UØ`QÄX·^s_Û¦Ì&*û/=…–<Îêöæà†æ˜ûZ§Ç·gwOM;\",då®IHœyš?¼Y(€q|„åÌG2cÊµ-K}wÛ¸½õ/¢v>?*ıMç\'d®pÁ¼g˜ÜHPğø¥Ce<úÄfô³­”ëÎ”\'ÄüêÖdévèŒy’!lõAzb@ö[b¡“-«4.3/	Ì,ÏÊFMNõtºeQ(ZQı‘ÕZlÙ“T>uŒ·Â|Ö)îZß’é#¸ÓH.;s~ë(JTnzØ_ßâ§3æ~ô¾Äåf<Q\nÂ2Û®ÁÃya¥h6bD¡mN‘t¡-¡FÇÕ¶E‹ƒ€nŒY:Ù—;RÔØó·Š—oWßûV6L*ÄƒÔ;6Yp,‹:ÑËJHB„òƒ\\N_•½Í“eà‰Z¿@æThsÎyÄóV-ÄW„ÖW†)ŒE·eğò,¥=TœQíÎ\ZÈq–Ûpô´!ÆîåëÙj*Ÿ2]-ó%6q¥2cwùl­VÙ›#úÂ®‡AE…f†šö®†ãgí=wm(¦yŒ½¡«I­›´ ÊÏ¦N×:£…Ö³ˆ¹€!a0\'±D®ÕFÜre+Zãoœ¨	WFy‰æŒÏŠâxöÆ+	Ø‘pØnâCˆÊtã8Ìƒéxm±Õô?òRèW­]¹eA\n56¨©KÅ×aÕöÙl‚Y_7Ty	\nNé/{İ°çM«„Â7\n:E	«æS‹ƒªlÌ¯ö/sbÏÄ´»A,¸.¾6šåT_µ\r’r4åÇÈ–ÅW\n³kŒŒœıq	Ï-Nˆ+mÂõ™?x­—rÌ¨¸ş\"ôhYcr&’[`-‡ÖÜ±ëâOŠâÀ‰à·¹İíWÖƒËPH Äc¡Õ-Kh:÷¬2c¦ÚÛ )+RzY\nå_b«$íRªOj²à k¤;jvæø¼²\"–Íº*:¹”E~r­æmD½%²âuãšpÉ\"Êıdòd\r…”b´YXvH9cn>Šâ†Bc1Á2â6“-\0ªı9©Şİ:oæv5Ô¾‡^”søœÃq©rU•eú§˜qKy[¤êj\\dÛjç×¥IA\njÖÙ\"¤K“µ\n”ëR©\0Nra„e±c¸säı¾{ã8ÏÈEÜ\"ÆqÔˆÏFYJÒ¤¬)*÷×è7ÅpÌojd9\rJ) ë0°ãn!BéR’B‡Ìv TqÙ‡\r´ñ^?í-Â\rœüd´©qŸ<côşş{ç£èoÿ\0+Ñÿ\0Y@şİxïù]INQÀÓæÖ$~6š˜-÷µ¨ÔÅJÔ)Ùe†Jö\'bæ·v.Š_&œG*‡8äP¨„asKæ™Ñ…¤jËjRäz//ík±zMÆL+$ğOˆÍq\"RœB_u˜X³¯¾¡¦mÊh´Ÿa°§e’\0=/_Ì—‹KÍ¹6F^Dhı¡,)qiR­Ì\nZI¾á@\\íp‘µy«©	ãåAun¼ªÇ†Ñ3mW5§“¡\\ä¾\ZÁfÂMwA6ÇÖˆÃ‰ªf°¢dŒd’Iƒ˜Ÿ9L«¿;ç_K>ğ‹XÖ[eâÍ—\\Ä0×ÓÈj4—¹%KR–U§™{•$ûfÃ­«fEÈù»9eL”êÆ9,\\¨•°Â\\öl‘ú5dî l:jÜèş\n[ï¯Llš§Êm.²¬µë{%Bu%´&—ÏkÄÑJ‰±f|K5ê)72Z¼ò2RtìÊ±œ¨ÂƒÁYÓò£`c…<8u©±Ó§2ˆøËMhWgŠÏ5JS• ´9e+IÔ¤H¬êcÿ\0Jq—UÌç¿	=Â£©+Şê&Æép¤£ö6¯¾¸éá)±úJZV³Õ[*?g+›\Z¨¯a-ºÃŒ0kÌŒÖºí¹­H=L.’ıFz´$\0EåË.mÃŸ‡Ì•\n$_ÊÜ·¥42¼l1ˆ|8À&ºÉtHSÉZ‘ÉÒ¾[—¾—:LƒÁhğPÎ§]æ­Õ8Ûd8u¬…\'õH>Õ®+úxé7e5_:RRfex”İõÑ^ÊÍÙ}ïåJaÆ+9n{)?¾3„§Gán@ŒAÑ„~k_“ä ]“)îÍşVÈøaÄ,ÂÜ¸¯b’§9…`°5%/òÜqMFy(ÖK):ˆp~‰²Iğªø\rJ°Z\\a¸çáHºF„n/Ñ:®û—½Ô-Q¹Û§šgyU¨lvñWÑÚr³eåŒJ™”-EôÆèÜxËo]kX3ºœz¥N~¢ggõà3\'!dL‘9J½ë¸†OWBôâÈ™“)pÛ$Ï*Nj‹Û§6—[CQP^q.(¡ 8Í•s±Ûj³bs~)¡÷’ìkö5¯¼Pí­¨íƒIn¡iOéªÆ³–Gáõ«Ì&ãp»éïeÁÚ§‘õj¥5jYõ¡KÌÉO¥R?SÚ4=¹á	qX7‘Øy¥¼Çìÿ\0‚eì{ˆc)º§æ9†»¦å%}èÔ—V„¨k½ŠP .\ZË.JÅòncÌÍ³QÌ‚€®r‡8•æçdr›¶©Ñ=½;OZ=g ÃUÑ­Û2Ş•AÃõ”d¤÷Tå¨ñüŒÃˆbÎ;ˆBïË¥MÅÎ‘ÚJ‰\rá‘P5u:TæçåYŸŸv^W”êÒ„Ït¤«o\0Õú2s˜«tSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠV·_ŠÄYÇH¹–0‹Îı×Àvÿ\0ÎøÏı9\"Q´g?q_zHş5]†\\â,[ı3_ÛMiãYÙv¥9&…Zt|ñÂ±µ!d*W› BŞò|uL(|J@il¯Eˆñ(kZ©\'sˆIÉ4¬„ÀœE•óÌü“‰Ìq†Òç8¸…%}/¯º«û«ô¹ÆNeÏH>à°±ê…Øf1 \'™m1Ûmm%+Ûô®íCJª(]š–[vOîXS¿Ôe6kFÆBÙ±æQ=”\'ÒYYÛ:‘sòBÏVîøIÄ+Ü¦LŒD€œù—nÆqìÇa2œ5.c­¢n‰HìÈ•†®DX®û\rÈU’¬¥.IZ·µrÿ\0¦s^aVŒ¶pÌ=åL˜ós{SÉoBÆÚARÑŞ+î¤¤ \rz·ØÛ}·`×á›Â‰ ^©UTEû ê7²µöÑÅå³\r¼‰±$ÍÊH£ÃH×#:É]š•ÆU{XaŒIÜÛ}©)dwó^VÆ¸†Ş£F8™Ò]ËqfànÀoŒ¨‹Cğ“-¾t\'Ym‹!.G ö”©]â¡^QbYC¦2àKíRW<Â[@Œ…jJ¦ÔÒÁiE(K%»][ Õsiµ«+°ö¡®i|K=¸î+¤–šØwl\r(W°m\\Ú‰¡½\"VüA\rñ‡ÅQÇÚ‘²Ğ\"@1ãíò.fYË`8„°²Ôl¾¶qF[m<Õ¢>½SÒ£¹‘\r/¥½aîôCÒ+Ñïá£_w@£¾Û³¦+Jé–ÂVÁ¹Éx!¶Åî²V²u,š¼j‚šÛÚmî€´È®£[M0E¶›a¸7<Q¶u™,7Ç—Ç™¢•Áê*cm]¸ÃÄfZIoHŒÄ¹#\n×®?<qšxÕÃ,÷ƒMnK“ñÈÍâ°ñ,«…e¬&B†\ZµÇCïºÛmö‡Ö‰ )ÍÕÔ &ŞpFÃqtsQ¤H“%µ7,lÛ	@:®·Ğ)²í¥<®õÎ³Ş\0W~­ïäÿ\0¥~ëŞuK¥ÆÛ°Z~ßnºËm–Zç×{„FL·Q‘mÉåÚÜ„…kŞ²&¹İSz¶TjLJö‰ÅA.~‘ õ‡<R‘ŒBÂ»{+†q,9©HfGuø«	(å=~Š!P#Ä\Zß±x;?z;;˜X‰Ùñ,[ŒÌ>µM;‡l[q\'—ÌYd«Kˆ)QJ{à}Zª]ƒü^±-›œÆxül«¦Ù±í†Øä]°¦VûDÚR{³ksYxş^B$lc\"Tb¸ÇœçEqkÍ’–ÚB•û»\\¤oÓÂ½ŒôDÉäN`°œëŒ¹56¾”5-\\ÆÚN»+º7è7Q¨­²^YOEƒ¶ŸâÊùÎP%\'lÏÎ×?ı»ó¨=\rÕ›oşgîUyÙù]Ş¾UÀQĞöLPÿ\0àHøõUI´¶;õ@™=‡¡ÏL¢ ­T+,•	MZd)æhäNÅXôĞ6€FxòPóHD@½eÁé—¦òòÖ#À,o	Å IÄXÅX19l4µrÒUßw˜‘ê–ô(ø›×„‡™*nuã–¬GÂÚBÖ©â¥\'A	EÜ¶¤¸H¸ïk^¶`×­İœÇuqµÙÕ*b~¹öî^Ü6ŒMÆÂ˜ÖÓ7‰,tQ¹NÅ*‡×mêŸ}jdm.ˆÓD)TjÁay¦&Phÿ\0+ø—£·3—!åŒÉŸ§È…`Jz‘a©xc*qO#rcèWªÔnË\Z@5è.xÃ¡ğÿ\0\Z\rC–Ì§…4é^ãÖöc>²ßúEhI¥ÍÍf)Uÿ\0¶ÖZhûÎºØ]àÙbVê\\bQÎŸï4-(ˆ4E›#•é±o\"s!*†”Ê\"Â‘*öØ\n|„Br¼ßÀ@|–&†ñUâX‚#¼–ÁÄšCå¥¸Ë0ÛZR±İ\'Q¹\Z…aø~oÆ¦>„7:OuşÏÚåóĞ%+y)Kn&ıÒ6HÛ\Z‡÷z®i:—¨y‡MO™13;;ÈµÙ\ZDÑÍA*‚rpN‚I¶Eî5§¦\0Ü×3HÏp!\"ÈÈ}°‹ º6_ôfÅı—X9ÃàÜ‡šL	æv±`•¸Ô¨Î- ¹½Öƒt´R­/é­ùÉPxvä90±cšŞ–‚Ó\rÅWÑòb%H}÷xh*J®\0²»¢úªÉ®²6}UáfÈ›$Û«R	ürÕdúÉtW¢imƒ\"ìsê>ÄÁ…kN‘˜ä`”¥Wäsqh‹ ’‡çådákŸ“ïÈØ~aÒ bˆŒ–&NÄ#L†é|ÿ\0^_HSI¹ï‹íìG…hÌgúw„”©›!zCØso¥Æï})x„¼Ñ)î¶¸ÈÇkX•6é ™×}”†×õ£ŒÊ5ÕëNlköFõw2Ì«ÎÊ\\U¢VšR¡#­æZƒ˜…8`\np\\ãÃäî6dö2Nw•\r¬LÉqX¢e·ˆ=IåöFI±k´:ã‚Î„‚’{¦õ>5…f¯sa¢;(X·–T’›jSo%\'˜\r‡•ºj™²›Á6Û¹Õ*µú[SU\\\"£]\n×j^¥T¹Ö7^6…Å;œ ×5ÊÊM¯rLÒ²xP¢NYmŞÈ²Äaf\ZoéòheÌ±p<W\ng==Rô¼BzI~kî©K‘!On4ì­…€°\0Vôèá#Ã¬/.»Û°É˜tøNMhaó’úÓÌ	§ÙGèœdx+{¨‘s½JŠ¹Á½p´è¾ùÀÑëÆÊŒyÏpäÜ›vÇ|ãÿ\0âÇÆ|\\sgzU:Ï­l5}ÅöéßsjÔ|iÉÎÑR–SîºQ{ûö¯Ñ“œ¿[¾œRœRœRœRœRœRœRœRœRœRœRœRœRœRµ¶üV™:FË³ŒçÆÀëè…ÛõñÄÓ¿oúöä·[uÖV”u(Pğò>uY‡¸Ó3™Rï¤:ÙÛ÷Åi’Ô«ı¢0\"%d¤ˆüüŞ\nCœ&2ßñc=ñß¿8VF@Îj’éì‹#¹æ£_¦¼ÒSÁa¥y£	IL8©åªJ{ŠK\r…~Ğ7\nw¯è6ÅdÃüûÆ>ìü;Œg¶»ß9ÿ\0¿$@3\Z† ióOóz»ŸI.·Íx5¼»ZG»áµt·GZ%ÙJõ#•FÒê˜IİÌe‘šÄÔƒÎ9î\ZM\'Ş,ãd©ó(]¾ìg™L7‰°›H¤\'Mù|Æ¹…»\'•Ñİ;w|<ëOæ¬_Ğÿ\09Í¥bø3nÜ8§#â	‰Ú:¯$2 \n=y€›yW{&Ğ‚&Ê-cK›rö‡†W¦92Vçfg˜ó/,Í«œú*R* ¥!4°‹¶yd‹•óŒBığçmöİfCn±ÌCÍ>\nBĞv)ZTA½ë3Ï<@ôjâFT8$üÇ‚.#©aH	œÇqÈêJØpnG«RGPGz§Ödfßy1öä¾_î¯<\Zj›*Şz—%Èò<â—yBP<³œúe\'	aïØ >9SÎXBÎ„#e[B€Ôk°±i	=\0ö·ÛsZûËş†øÑş7ÁXï(;‹¤²â¶½ØC‰gs½´X\r«ÒŠ[Sµ$)¹ªInm™D @àÔ•|¾ŸjFpwÿ\0{ã°³ß9å½ì¯¥Iç9jİ°ï)»o:İØıpì4D‰e˜Ñ·dfT$GQ;]mê¯âT	÷×Ü	İ{‚pIS(™x ñOMÀÁe—öø?·ı°Ûöøäƒ“ójŞUàK$Ø’Z^÷ñéÖ«Ùã?DvÚFgÀ\r”â1”¥İ(Á`:% V\0Ø‰dQÌº\\¦¹3#Û¬‡7odâ•H[[ı£hSªR2ÅŸ\0%›,şàÏÇ;Ñ2œ½™Päô®\">’†­N ¶(\'Q:¼÷5äŸåNÍyc;àØ#X.#åCÄKR4thÕËQÜÖh\r[ä óœCÍ# ğT…S‹qÄ(Àsê`¦39ÃŒş¸ÈsŒg·=¦•¸=\niìGy—B’ë.ºÓˆZOTM¾Ñ±Üo_4dlïÒZ€ç9C>5%BÛ‹{½ß:—µS½©ª¶\n\"ªÛèí]PÀ¹2WÌ†Jù4™0©åKÒFå–ªU¨Tˆ±(\'	¼üCØıüâ?“Ğ_\Zâ4ìÏ‹ø®#ˆIT§Ú~mâ­Wî•¸¯a\Z[²l4…t\\¾6q²&\Z$l	†Ó)eÙËhÈuåø¨´àSwÛb¿Z–ÊImQœ²ĞÛ+>ÇTúç,Ø	“’3ó‘Ù²àJR±ß9ø,€à?§Æ9Ò™[ÑÓĞÓ\'*øf^ÊĞí±åwùŞç§õ…â\\SôÄ{ª—ˆ3d÷6QÛ[Ör€{»[¥b1¼TÙ4}åÌç„?we3wedĞc=<ãg9Î?ÏËş9²[É¾	nÂ\\	İÌdøoğ¬]ÜÏÇÂJÄ1å(„‚±%í“{„§~›oğ®å±Y\"«Ó®…^xS\"ó%|>ï˜ÆN‚ùˆ‘9„?¶?_vÇ|sÌ|ôBÍÑ‹x†•d¶±¥AF*B‰ÛÏ¯_ı*ù‰’8KºÙÄ±‘ÿ\0Fø2PGš’èX7µíkTì­º®î¥OôßÉ»­ù™+QÉU%i·Gµ*Ê0%XæşğvÆÉN ~syvÏ93:şK_@lÙ1‰Â‡›ÖŸiX~$”Eæ²àqlsT€ØêVw„úFq¶#Åx®Ö0×-À¶Ü‚¨:î’ApPÚùˆê~»šƒ¨¢áRşîë*„¯”Jäo³l…½\\m .òI#ÉÏÎË\01˜		=Áæ…*Ró’Ó•â\0c¾}Éä—#@‹7»-¥‡£¶§ˆæ8Aå\nç¼Ëı3Í˜ã“]‡ˆ%¥İHŒ[}Ô2•_¸íì<ÕøÕ˜t5uj{ë•¬hpo^Kv¹ì\0µbeäAĞåÃÉ~ºQ8Ïcœ‡¿||wÇÏ8ÛÒ_ƒ‰qTwÚ£âcK­…$¹tëNÚ·ŞÕÑ|Ã¥áù1|æÜhªc¥(u\nme6Ox%@5ú=óœëoSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠV¶Šè^=\"å¿¯İ°zø×æeü®Ã@TÖÁèV^ôê1RŸR’ÂÈê»|tšÑ¡KW(\n/(<lÿ\0ehMkÀM†F2!úíg¾{ãş¸ıyêœ^ğıL4~Š‡rÓdú«’JÔß©êk„¦g<ÜÃÎİ% -iN‡,‘e‚mµ«ÄšªĞ©JFèsRÇ°ösI²W£[“AÌö	ã*+~Ìxòó\0ûi®)eÜ¥—æáíÆÀP9“YK´ØRB‚µG	±Ò£Ôß¥…l,…‰f|b<¥¹?šC!?Ë-ÚŞ½;¦å7Òës_}KY8 J´ÊÑ•œÓBh¶ªAê«I\Z\"ŠÁ™±åã_¦<{ö|÷æÛƒÃ^M„‡F© òİF§×c½µ`ósng1m})!ò•l°àJCko°éã\\‰TUrófÉ]FÕ;ˆM„6¤4Ğ7æ©ÁĞ¦¢z±zeg#;ÈÇØñ?\\sÏ9[…Y.¹ˆ?2ûm©´–Ùî¸²êÂ\0U¶&çİWL»˜sÖ;‹·égÌJÈÕŞ		IW‚oî¸Tµ%BâÚĞäL\"<I¨Q¸œdŒF\0*S…F\0/|øà]…ãÛ¾sñß™d>ğÎK\r:0X@8Ón\05(¤8 	®ö>ú³¹ó³/ºÒ§È<—Ş±°î›\\]>>ÛY(j…ÁÉcëF%Şğ÷$\'M—Il ÈÂåÀ”«5(í›$µ\0$™‘à>EÍwÅ‘2şX‘\"6^Cî€¡­…©=?éV›îŸ\rïY&MÌy·1c-Ç8©İi!™C|âb„¸l‰ññŞº<r‘«ÂÆ³¢l2ØÄJRæ\rşü¶YgqœZHTRS‚ø`z‰À1cÓÎCÉ<:á¶AÌùe—åeÎÎ­\rúÇsó³¤úÖô(S{uÚ¦gœÓ²î*ãIÄBSÌ{Õ2[pÇHZ@Áp«øÓI¹®ŸwT5“% ©†(•Ÿ2ÛJYˆÕ~n--íLÇ§@?!ı¾˜Ô`rycÔÎ<¿ls¯¥îTË\\>Ë±Á¢¦Î3!Ç4•¨]­í¨×Jú\Zö!qZ>¼äèOÏÃ£òÉÓv]OBw¹¬Ÿk¦0h‚°¼|³â«¹c8íŸ#>ÃN+çÂ?ÎÓói5úeÿ\0\0ïFMñ*úÿ\0Ï$oüùxWğj§ÿ\0ÃFˆ8ğÇ€İ×‡°†/³>Y÷»ücş™äÏøSÏªÓùÎ¡p{­ŸMºT—}=Öàoèokd¥S_\nÕ{í‡í¬€§D`ßÁ­Š{:x#ÃDµÕTIcÄ“3“\'uÒ«\Z%`°\0iŠJD±©\0`”¦TVB!›ØXc\'>æt4ç&KäAcXc”¶ÜqÆÖ„´ş¦ÔÙºÕ¶’<ëˆğp!ÿ\0Ioèì cFT©œœJBÔê’Ú\\CÅû.‚~­èMcÿ\0ôc¦Ãº8¯ÃõòÃº¼ãûöïÛôÿ\0Ÿ0õq=–ÿ\0Î’uÛ”<ë¶è\rèßcl!ÒãÛ	6ëmÈ!]ÒO¤H­N]Ê®,˜õ–4N§iL¶^±<Šm:“FË›¸1Àãà á+}‰BG‰Å¡DŒ…D&,ãÖçç4›³ãğR§PÔQ3QêúéCJsı+‡t net\"¸ó5pãÑ{ãÌL•&âx³ëSMÏ”Æ+dE[Á*¯XâZIÔ®Y\n²zÚº!šÁMã#ÆÜp^1œ-áXCœ÷ÿ\0h_~ÿ\0Óãü9‡#‹ùåCüå÷cï®Ãÿ\0Ùÿ\0èâ­¾˜½”ÍvÖùßáíW´\Z½N\Zfô5ÀíŸ/¹éOÏÙ÷ãíßı3ŸÛŸÅüìúv¿î“ıõŸ“çÑÃHüÆnÇşzàùl>ê´ÿ\0Ãù^ÆkŞ·´34Q1É^¯ge$¤Å&–­\\<Ôãî3>{vÀ~9Óü1Ì8†aÉéE*sœ¤‚‡İ^Gújp£)psŒcÁâ!\'‰#K—ÔHÔzû5úOó8®F§§§§§§§§§§§¯Rÿ\0úí)^x¥kYø¯³Û¤dŸ¿é‡×¼g8üà<‹Æ_Û•Øb´âÿ\0­oûb¥¼.Êÿ\0q_Ù5¦2d†ı\'Ş«ú{q@Aõ\'!ˆÚŒà8\r=Aı€äCaòÎ?˜0‡ò,c>ÀI–Ä4Èuim¶ã¥D¨„š¸$u;X\Zó¡1dâ8Š›KeÅ8éJ/u(¹ß#Ş÷ûêpé®‘G÷\Z+²-S’¨*àÖğãı[)2È„G›,‹ªcX6YÊÈÆéš€6æÃWœİ/^P“	\"à#NˆÏ,¬Á<=œ}!ŞÆD˜io±â	é\n6RZV)ğïƒ·ËÊºŸ.ğCˆü§\"‡æFå$ù¨!V$]¥\'I= ‘ğ½B·Övö²kEhsñ–”Æcˆ›Cˆ\rš×o¬“ç8Š¾°–a…åÓ\nZÏZ›ÚãÓ5°ôªA`MKğÏŠ­qÙa,¢)ah\r6µúÇRA7±6;yt­7¸};&´Ü‰m;¥Õ/š°P¶ĞÀ¾’ykJ…´¨Ş²ş·[N5\\¼É¼XÊ¹Á ¤UùîB×5ŒÚØc{è#Å…+´Á\n£Ú±«LÂCÈõUzF>aÆ9zBel2VWL—•!.Fd2‰›YN„£pìv¬—„xƒlf88t¬\"$ë‰O&D”8‡T9D†Ğ¤¸›¤t:«)’¹ØNMòùÒXôT„ÍX\\:¹c0’dI„Ù…%H—&djr	#4îÄ„bÎ7.DÊò\nÛLÈ’ğy¦\\üíşj¯ËÕfïk\"ÊØo°­{š±ÖñLAÀÌ6!!¢êTÔFåûvR”¥)W^Ş5*µnÇxR°„–õAOo¸[1ÕÏÓ6äK+&MˆÉ¼Ò`Zãˆ²\rA(QˆòQ&9»·…éˆÜ— x±Ç8zñ|’¼~KrZzçšêz©îˆğ­£‘8=â-ÀÄ…!<ÍhC‰ºÖ]Ï©°_b	¸ Ş±ÖÇÒhõ:é·¨”V¥ed0ÔsÈ++D­®XÌµÖÅÜÙ~}®eÌ$GÆ4CR½³ÊHÁ3°’a9…|uk{ÀÕ@Kb;òà$rtÓsky{·¨ó÷q8qUİ×rPÊ{»•täø\nµÅEñ>~ƒ­bó\0ü¯iø€ççÇˆÙÁsÿ\0îùı¹«};ÕşLÇënÉ(|l~Êß¿“Å|qÃzŒO·ïs+6xçE€ıÂÏlg¶~3ßÿ\0¯ñçˆ]Ñ_±òË¡j\'Î»¼MÉ›[ÕÛMN{\'ÆÛ/’İMÚco™Oõ« ‘3œQ¨%ìi“eK*“Â¥&…)ÍO€©¼È!+Ä0— áòæv˜‹!µG”ëCR`MKˆ]âIİ+Ñe%D)7Òpÿ\0¦³^bËLf<3“å¤9)Æb¸¶Š:5²c‘ºèXPR±µKcaì:ûs[z\'~³Íoíjº\rÖÙ=ioSïÍöÒ42	X–ê>ÇÂÂïİ\0•™ılrJØZlaP½Èˆ-AÀEAŒ9fL‡f<Ø¸^\'ç%aøÚ¬%Q\0Há“Úµ ²ëAÈïj»$ln+Îo4f|õ1]š¨xÖ]“ìR6çÒ\r…ˆ³{?W¤ú·­Ğ¤~±«VsèÕ©B€Ã!×ŞÏ¶Z3Iı_Åf2èêy,{•V5_[äĞ„¬ˆ¶gÔe¥ĞÅiâvIöŠ•`KÏ`¾‘¼Rw1ÈD¼/&/ˆ¼4:Ô)Åµ¤bŠm0äFš§\\„êu³!BÊ[Rµ%*ìzVzBa£¸“YµR}”À˜ÚÃ,nJ!¥\r‘! IW¬ØØïTè­\\{h¬j:‰¡ãRø5GQ©¸P¤‘l€šA.~º%nÇÌ6—d¯¡‰š3\Z‹ÄSøµ%É+heQ”aâ0¯C1•å×bâOµ2o1™rÃ’ëpuÒˆP£%zœ-Ûœãš¶Jİ \'¹YæAÇ3OrÌş\'MD|GÍ\\øX!” \\3¤,—fòG±€X:÷	Ö5,\':‰òÊvq×ñÙÒvÆvÙ•ªµ$w©Ã²óp1BDN>äPŠ!’;Œy(H)R³0©A€#ò[‡—Š‰íêí=:YF«ÅÉQqmtRõÅz	è…òğ9¸¶rÅ˜Ş,[‘‡G|–5÷–¸È	Nˆe6\r$’®§qbzà‡ÿ\0\0¯/Ó¾?Ç·1€Šìğ”…îş¿î«\nèH®u;øÎêåÎvDü&²à°ã9ÿ\0‹üû÷çlpfÊÈ(éİèü+óıùJS§Ò5^üûB]¯Ñƒ›>¼ü§§§§§§§§§§ªêÅÕNØ];‚Âš-]¦Úk\rO®Uœ‰ü1ˆz‰\Z÷m\nfV4„\"	ˆØ”¸ )HŠÈN<åd’¬¤ˆĞF«#0ÚÛ[„\r›fÜçœ>ËMßd“cuBPoTå½\rL5êQ¶½Búœ^5“zÉõ}[g^z^UÆâ¢®¶kØ™™Ó7Jí§\\ı”ãÇˆûöR B8yÎ9÷…8“ëì¤€ÛSZÌsÊiƒaqĞ¤¾üUâÓ?y÷UËm\0u³H!6;U}¤ÛØœåIºßu  §âÂ´Ñ½½Ó7	ƒHÖ€>aNëLŒfd®øğ4;Î3Ø8&vW¦(©¶_	FÄ\'¿ÓÜÿ\0e\\p¹ø„ÄóÇ²6 H$3-ƒv²œN‡îPA²­WGĞo«>Åï=›²úÓ±åG§Zÿ\0„Íà—ûk%¥­h<µác\Z7UO%ÎF…AŞØµINÅ\ZPHÏ`\Z)kl |üEÙVÜEpœ ¥\r6ğ¸}1qø7ğ1u)rÇs¥WÚÚM…rÿ\0ŠÉ•ı!g*Nq¥3Şúşì¼ÂË°‘s€¤Êƒsşè}C‹/\"ÏnÙ3¾qÉĞM¦4é[şÚjÖá»JıÕuıÓZ[³C˜R^D¨† (H£\ZE)M	\'úàÇqØ#,Aì2M\r@i`=}›‡áøö¨Ï£˜Äˆé\nnï(R|ÇQjó´?;Ä9‰)%-!=Mµuª‰z|6mkFªÕš|¦ë—ŞÖÎvbË¥êè!Ñ=Pl:\0Û)¨£S\'w·eÓH‚·£“«&-(O;\n$ƒ²­h”ö¾Pf˜°¬vdvPµ2Ì‡\Z@rêU‚Ô=<«¿òki›ƒGT†0†e ÆÁµ/öd,¼¥mŞXŞç¥Tm·7±-}„h|¶eÇØÒØdD7-UÌ\Z0‰æEÒF‰™’¶ln#İ-Qé””XF¡ÍÈÌ¦n³ü°s¬8†`¸/\rq|]e\rHRm2]Y³#’R„6“õÔ£·—s¿1	OæÈ;,6\"ÍáÌêçë!KV•Zû\r¯±´íµ³µS¥•ŸQlÖÕh&3í§­ÚĞUúŠˆ5SM]LF)›9úÂ¹p„ô³É\n…ÙSôĞ¤Zßíœ	Z—ŸU`9^VjÌàßG‰../8¼««ré7¸*¹ÑkY>\n¹k¡0L’±<]&ö˜má´\"¥~_¥l<ÚPvØj;\\¨j;GÍ¡¡«õw¾\Z­C?¶ëá[úísÆş¸LyŞÄÑSà–$™–Ê¯BìÔ@”\'®ŞÔœ› W‚šÕzmn„ÛÆFÉáÆqÅq^!àˆÄe¸Z ÏyÃË-¨”«p	Ş×?…`™Ó\0ÂòŞ\\ÄQ\r	q§\n×\ZB™ÒáYòİV¹¬ê:®J”WÉ­vÒ-yÖç;Pà°êR»a™Í$°ˆ¬rÙjç\"aŠe$¶Å¦6ü]Øôe«w\Zc,ãT¥NIŠÄ˜ ˆx)ı ²Î„qRb%-6¶š}HP+ZwU•µÖl®¿‰«q•âYuƒ2<´Ë}Lv\ZŞ}\r„‹ i}  ‚\0-Ğõ¬e¹×\"Kâ”ª&Qg!Œµd‰St\ZMFkL\nz¼Óh\'ùC-™Sq–“×…;Êµx\nrN-”¤£\Z‚? rûèÉ”°üW<º¹`¼¨‘–ú$\n‚.¤kcÓÎ¨¸é˜$áyT¢PSÚ%vuNLE±)miÖu¼àlí½>\"ªÃ`‡ÿ\0§uw¸;gÅÃğ\0b1Q~ßÓ?§löåg§{‹şDNúDIfÖ¶×áoº³ÉÚxå†/b¯¥0ëoıb‡ÛøVZÈ»ÏnÂùùùışqÏ·Pó¯ØÙx)]w®I¹i×!Pr4î	“*(ÅU—ê\'^ŸÏ¹è•—ïh;–f;ãÈ9_†KìÙ|uiÄ*Şà{ÛømÓßVl\ngÁfDQã=Z½•s¤ØÜk‘{íjšq™Ã–À¿èãı7aÔ°MÁÒx%kS¡«ö}ø>Ã4Õ“eÒjò_]Ú„æõ‹\r!ÉC*¨Ë¦R.Kä•Ki‡{bü¤fìR&•³,f\'7+ã¢rÛÄrë=¦nÜíŞˆÂ24³nojgZê’	5ùşâ7x“Â/¤°™p2‰Ñ%K:K]¡PÔ¾IÃÖN‰œ~²• \rÒ£¹¾}sGh÷k	J;¾PÂ=±ëş&­-¥.°NÁâì\nl&o4ÃNR° ÀNŒĞ§\r8Ç|\'Àò6áñqJOĞÍbZ£L\rÅ®bc9Ìcóks/&é(:IÓï\ZWu¶£-ÀÛêj×)JiÒ½ŠBT a¾“ŞÛsŞ°IÒ‘¥Ú3©5Ä@¥6´6ÕÛË¦°ÓÌ]}“Ÿk°ÖÆì¥»âÑ»/M+©,d/jjalPì¸¼,Uõ3üÖ‹ûŞÎ`T¼Ix«qäaØrP·Óô’Diò^äòXm¨]å\"1eJRV¥¢Qd&ı1”ğ&qÕ¼—‚ÇÁ\\cËòÙBZZV©kæ/™.låĞ–“µµjÑõT­„Y,–È !,’J–\0v\0\n(¼XLc·4ú­¬«õ‰Vı{ÆõïlhÌÂa¶P›%–ÛeÀ!´„$u“_P{xäB\0ğØwÈLíóÛüÿ\0§ QÔGÆ§(;ÄU tŠ¸+ëku‹N—G¬YIaÎD`Ö¡u7E“Î>Üú†ˆÎÿ\0ñ/Çü¹ÚüFŒˆßí<ê‡ÎßÜ~Úüû~RI\rHôwAI\rásj ï¯K—ğµn»¾Û½PôğÖI¶Ğİ‰ä®Q‚–6Tlöòœd’yT©È±˜óajŒ$‚½Â“ê©Pid¦ &œ,‹ ÁcÚ&¸–ÛqĞ°ØñR¿€ê¥~ªGST€ÑÕ“ª•ÄÂEWP.¨*ı]bxÚ­öa_4=¡AX<…O¤Ö\n}ºC0ã\'n4œç\01œ´IOëw~ú¸=g7Ô`øËì²´Çm¥~Úu«Jº‹ï_ª—VÙœéÎ[Ö] ÷aa2i+§õ\'s%o6€aˆ×ÜààŞ®FYÀ0¥9!ÁŠM8°ú9ïñĞ‹ƒz¥˜†!.ÉÂq`ÂÉÖgˆ?´ÕĞ¾—:I\Z´½ê¥Uî\\ÎcBË«+CTw²hNõaêÅöØKà†cLÁ&Êëç0d$I\01–‘–_§“KÉ„\0£0rëâ›ˆü~ÑŞÑ«IQmLºÒÿ\0Ñ¾Ê·m]m¹IµÂêÓ8ªjqJqJqJqJqJqJÕoª±T{­×3G5¿`Jêeú´ÕLhİ—²/o‘‘!9#4¦>ğÜ0šÅ€\'V•H1œôÄz€4È9VÊ@aJñU$¤¸ğKhyöÌK¬/CˆW‚ñ±ŞÇcmê5İ]#kÉ­Õ^ôõyëo¼‹Ÿ˜H½ªıo±0Õpf<’¨XË¹¯ç«NJGY	Î,i×:¥)Q)Xˆ…0…ÊM)[ÊD”§Ù\nHğ;oããó¬‚/ô¹yp»!qå´‡ÓÌœî\ZÒd;sì-ÄŸX<ÀP\nğ°µİÔ:Úãp×²üH=C%Rvõ?K’–Ä½Pà‘wÿ\0O\n\'¿Î\"Èß[ŠuğÎDj4ôÿ\0qjBI¡È1|j6ú—Ú”ÚnàK¥% ír¤èó°U^-Â¼ù¢Å’˜¸kbJôÀláQƒ²TŞÄ0IHRÒwÒN¯67®-·Y?Ó¤ù4“ªæÖË,rMoSsvãe‘I4İ½ÛÔR0@Î).ä1æ˜ÿ\0(°ã¶yF¬Ñ€HB–d²´i\\Í“~„ŸŸ˜«òx-é„â\r5|V<§ÒC(n–ö„Ü¥	Uî6Óÿ\0¥aØÒıu´ºmnUõÓ›¨ÖğÜu.¾:ì×[’s;V\0¿¶»#E†Cjà\'Fˆá?6¹–buo1évò\rÆì¸„8Úm]ä)&÷	>ËjÅqì3<e©®FÅ¥ßZR‡Z”ÃI’ÁR»×Ğ–Ê¾×N•ÙFÕPZú(l¡ª£>w:s¯`Š!U8˜µÁÖÙOqö†Æ_ 9µÁÛT%Rà ,N\0,NJŒ$g˜¤‚Ìl—ŸP1,İ˜pşAÄ°èIÄ¿3iO3¯JÃik¼´ØE6¹Â¸)yo›§C}æâ(H<§^Ö–+Ü, o}­ãĞÖÏ™Õö;L °˜\n¿X*\'ZêÃ¤%\ZUu\'-…æ1f†2ËZ@-&ğ.-j6Vµ‡ğ(#*\0!\0!,Á>ebx¾)‰Î‘%Mœ}Õ-HP¾…)ED_ÇÈm]k\Z2Ñ\n;z)mØÏcÌ¥ÆÓ¦ÃR!)\nÕ`M”A¹ó¯f¨j3îª]·Æ7\\v#°öHYÓı\r³’7×q6Á²3¡d™5ÙRq`€©Qê}49;é¾ÜÅ\'UªÍ¸èÁûSİ‹XYa¿ekëu+ï\n€Âfn8\'ªºßq•‚›y•Ã7ŞÅ6ŞıëŠê]Pô²uÕMâ™|·$öõp}\"Ó6c\\hµÆrwR§.Mî§½\röD¨YÉyo,$z9sååÜµ1ˆGB23ªŞû­Bße\\¤«2JM£¯kNîsÆÕî˜¦Öûªfê–-íPÔ:ãK îöÍQƒÈ«Ó\r±´GdU©›Då.«]Û&\r\rÏ9D ¥pPœÒğV0xyüæzg²§ëiy¥%IÑcºTÇ}şuc‘hy8bR®jJ1tƒ·^Y„FıSälE@¨Ö†8Ç#“ª½dze4 &.Òâ3NÊ4gprÛ„K>Š¿l›0?§w13(ûØ¼Õø (ÔâËóë0fW3ás®;ÊC%Ò»(¥)Ûåğ«NƒLƒÇakL­\\Şã¸ãNóUí­$À²‚€\Z…zçÊ£VŞj»gF7½??<Ñ´ıFj2kˆ‰\ZcµM-*_®Vq*ñ<ŞÃqX1ì¡«…M@©aÙp‘>{lg™yW57Ø`ÏËlÂK*t¤:¬\'ÙËqÒ°î#ey—/™‡Âb©}nºî(ã\nÙ*“ÔA Fıj‰.ñ8(Œj œÉ\'57´üÕèÉ?İ\'@~aQ\\Ü^pSÓÏÇ—lwıpc·|“Ó¹Ù*Ê°Öè	qx|iNá\nºI@;\\$Ü_Ç­lÿ\0ÉÓ…q÷\rDrP„czP³`^Òã÷ÕRÇKm°¬ËíÆ3ÛÈyì,øãî,çñÏ†Ö°¯Ø_cï½ãĞìÿ\0-ıÕ–júrUg« Èû3*>¢ieÎ¦ïVõ\r	¡!ÂojJr8¼ı&¦Ä¤©|,È´ 7ÈG‚ñ\0!n‡JÔ˜ÑšN©œ±)J*-ş»îY¤yßjå?H_J¹Àè­Â†ÛXŞc– ˜˜K26l}iÖĞqL4ß]6æ/À]PØ=dÈG†íEı\\œâs2¼ZgúÒéXq É	,svç\"×/U7˜…o»8E’’@²!‚å…;™rÂU%Ü!·‡‡?jPÒt!N¥æT‚væ¥mXØŸ1ÎŞ”|@ÏÙ\"~\rd8ò—!‚\"Ï‚¹fæÅúM–\nTÆå:®¡¿MU·^íÚ•ô—§¢LmuY_z×_îYU®İ] ³Å”6%”Ñ<<]‰TäÌÁµ\0Ïtç8g_ŒÇ˜xkÊ¾Ò±Lg(ârWKåöcEç+/KŸwc:X\nz[]‹áÔ7¸š>»´;2¥½öeIŒ‡™æ\n“­(Qp\rGr$ØŠÕ56»¢ˆ”Ùş;i,Bæ€ ×µûnÀµÍ³/y÷ F,)fctåÙÈ€ÊNæŠ},\Z0€Á_¥_rzS%ØY‚Kn8¢ü¥Cm¾Ì„ÜªC‘Şµ¸ÚIıv½ “kFÿ\0Ã?ÉÈ‹áòã`Ñ’Úf)é\r°®U…ÜÙ5?±º¤8µ}më\ZJô‹İYİÙ]#²8ëš¦)Daù.P?Æ$Mâğ\\Èò‡=ı3‹Ïa`AÉ8¡yI¥˜*)×ÀBĞ¤‡\Zq$–İhû Ø\\`Rv\"õèO8‰•ø£•ãâø;üè¯-*·:3ÀwØ”~[ÈVÄŞ¶¤İ;×¸#ùğCü¿\"±â‹û»Ÿ×¿ÇíóóÊ\",±÷Vt½) ¤‹ñ©ÙÒB ênï¦ËÚ?æô…Oš–´„kìöåºY²Yâ¨dI’=ı\"º…6yeÁÁÁs2…YïÙ\"Bğ`N‘øÀ»ë!ÂsÉØ{v¶¦y‡o¨«ğñûkó+é‡œÙÇ=#óCíÅF$Q$EiOH\\VYìé\r\rE¥Áîµq[gÓ_©äëâø>Åu™Õ;Œ6w\Z’¸eÓ^âQz÷3JúP#ÛÕÎ˜œ\n‰D\r*¦ÓîhÊ11åy\0AÆjåîAó;²õËrñŞû%£…àÍ;ü—\'¶ğAñ+RQîV~Ú…îİ/Zğ¹«…EĞ:ûFğŞT°™Š{>“guh/íú»;+kÑMH`Â.ç•ƒ‘Œa3áÎ1Eí,•¤›€w÷€vµêDl-ÔÇå9‚ciï8bf)º\ZÕr‡Ö”Ûqc²|-½v=jÕ¨:ã¼r\r£Ö­dé%[¼]\ZşÍOGèÊ×c3Ô §sHô¢ĞˆEc&aÕÁZÁ¶àJÌ+&– !p1\\š©\nRtèÒ¯\"¡ß…_YSqÿ\0Šq5FK|Â…ÌBºOéêú$¨DîMúä	…ºtY•—¹7µwb^ûKoÙ\Zô²º¤#NÑê‚¨XêÃÊiƒÇ÷®˜0÷µKO\Z’¼2¬<F<à@¨Ö‚Ù\0|Èª6çËš¥ó#·\r­6e†ç¯­ï-ëY×õt÷R6¸°º÷)©N)N)N)N)N)N)Zòìh‚OâBĞ³†OªOú¹6€\n±œÿ\0¶ 3Qè—ø¿\\gÿ\0Ò.U³şfçïïş)Ds¿‘üø^µÎp¶míßŞ¥¶‡<*°ÔÊ»àä·)iòIUƒ¯Ï$ÒÎoSŒ{\"Ó¿16¼éÒ¬^˜/>bÖ,‰~cÅR–àƒˆ\rÙ@Xyß©ûvóNBÍ~ùb\ZaEŠçô±˜’\\nÅs›Ğ¢}D\r)l*Á	÷µuZì=›Zj¼¦K«0ù2M=cØi3CÌ¹\\5Ê#T½Îæ±i|mµz±_ºzÈÔĞÕmÍMŠráŒ!År\\Ø™»“öŞnC÷u÷ÉİÆšR–½Á\"ÃËÆ·Ÿ¤[ÍœÌ9w4a0¹°‡£ÀÃ02Txøª£…É“ˆ6Ùœ>²§ĞM®:¼j*Ê\ZŞN*7—İ£T+’´v^ÖC39\0%©Ñ®Pò‹0eª64éVzŒà%¦ú\"É$˜<ÓËÊø>]Ë€‹\"d7&¥\'×¥¦‡[¨\nUd8¯Ä#qwçãX6	˜¡e÷9/;dáLÏš²âR¯ë]Œ´Z÷;«sUUtÙ\na*™CŒšîwºëáìh\0Ó2ªÑFáébK™ÈFb¨Ám#jphÁ¥…Ig½.sœ—ä-Á•şŠN_…ØÁÊyz¯¨\\÷‚¯äoÖ¼ğô„Ãóä^-ãƒ2¾Üœeoşpû ””§Õr´í  ‚›yÖ”:®µBX£4UÅ:€=Àgªb`0”­*Ö÷îŞ©éŒÆd^xôÅã’üDüã8ç¨üÆÙÅ¸fÊm¨Â.ÆZIßH%H>VPYùWš¼ZÃ¤3œÖç5-¥æPãjP²v°RR¡¾°@¹?o‹Òÿ\0Oµ6aM¸¸Êµ¶“/PÓ¯ëÍW!„3»)÷r-sÈ_,ÕaKÊµªV~\nñ	Š¢ÆD.üóó1Î’ŒÁ3AĞ¹)HÒ‡9V<+ªrã.9—áj‘)Å\Z72¥Y*ĞŸgÖØ×`*\'¶;¤ı8)›˜ú%5Í‘·ÅVÓÇlĞSm1ÅjÃdé|&if´È5ˆç‘…RóÔ§\'%•‚vNÅ­ù‡v^ÚPu¿»­dmæ0¦¥LÄ-¿-hŸ\'šÑÔ\n>°\'NÖZH°ê7®Í³ûÉQÒİ:úeläƒW+sd»cØW9ÕD\nšˆHNv¬¥?—ëãÜN—Çš‚˜)ğ_¶¶\"ÃŠ¼Ğ1Qú£[Ò–Oao:«-áÊy^·l\Z(åâ’µ¤j<Î÷6ÛŸ«á_RÍÙ«µ\"¼éû C«uYn›1¢Ûê:òZ4€Ë™è¶ü£2JLÙµà‹•“Œ–V¿§¨Q“…€9ÊÀeœpŸ0|ªciÂT§«ÄÔ®f¤±Y¨!û‹<î÷•üÅZu5­Úó?êIE!¤ëüF¥º“°œ MÈR@RIß©6¹;‚¶ØÏ»r¿¶+0Âü¼ÏÀ²h‡÷çée*bçªNŸ—ò*X† U KŸ£}3ä¨% é%ÍWµ·¾çz®>µ4-ETZ`¬`1øAEŞh\nFÎk‰-iêŒHJT­j19}—¹¯V\0¼î(3ÏÈÁwéŸEh1ßÏœSiZ˜ÃÔãZ¾¢ùá\Z‡íXšÑ¼yÄqDå™ísKk–„-µËyÆÖ9D÷’µ*ãoæõ¯õîf×«¤õ¿¬eÎ|sŸHÈl[çíıœÿ\0şòƒÓå7Ë±¯°ìRïãõÀş5µ¿&ÕÇl/Nÿ\0ãŒ;îSŸÏº¤”.zÅZø)=Y^©\\[Y’FCbM¬øy\'õ\nzsH‚·V.F:ú¤zãZnr›(É\nxÏ‹Nª<˜´N™†®1sœ!µ}¿U´‡—%·aË#bo_¤Ş;ú>q/ŠYá¡æyp0´²„¦%ÄKnghÂëu¿[ô5ñHæöu®Ø×Z=+aU)¦häño§cøƒRˆf¢î™¾RöÖqÇ¸Éƒø…ŞLäàyyûŠô{cµõÌœùn]çÂ[rcªí\0×5vä3ÿ\0DĞJğ«W½\r¸Ã|UÜo}ÌV{GŸw”óŒ·Ê\ZÔû®¾¥È–|HtèØ#lÌ’EªøUß°Öb\nŠ²´	P¶‘`f‡ŠàØ‹ù½³8Ë„†š§ˆ¤­­DŒ>‘yz´Å ¨úqáô‹:—‡.v-.6Çj™NG‘.[®EÂ¢â	¶˜ËrÜùÎ¥G¾ˆiSm¬hqÀu¡8Ãé¡ç‡±&aŒ6ÔcKÌsã¢S-·¥iqÈP‚}Zæ—N„›)v­‹u#Ú\nıÓ«¦är²C¬Ö#ÌãS¬;%m˜ÛVÉÄKç±İ-œ85ZjgœáÁÅ\"l‘À¢—“‚	 %ÉÜ—ÇvxÄ\\U§¢æDµ}˜pè/ˆŞS@µ\ZnÎ%±ÙÚkClº²µ\0Qr¢+€x>VYÏ¸t¸B&\'*/ç,±‰¶—abÌ¹s!‰*i‚±ŞE(Jì5\n¤û3_\'´c<[&	ü<µ²è¿²ªé,VÊ¤ìñ7¦îmÌèÇrÀ¸	ğ#ÍjsN‘À`bôGéôf	š\"ãîÈ•Lã\'\ru´Nƒ‰2ü,N×Ñ2{u´¯Z+i{Y[Šö‚\"ã/iÊ’ğòæ&ó%/a°ÇdÕ´¨ÅÂNmHk¼êS¥{šçX-º¨Æ&XÖÆë‰uº0%lÅï*>í\"¥¶Vl‰ÀÛ¯¬&‰*ÛdÙ`NjÎê§Ò\\ Ú¤ã‹JHñ?oÅg*VCÃ5¢îá8®ô„Ô}·áºÑKğÛ{bìd’Ö»¸›(šĞ9£Ñ{<6ÌòÎEÅqxæ¸T…¿ jZ¹h›\Z{¡*q–ììt¨­\nŞº3‹¥xU‘3t‚¶Z¬K)h$qô÷k¬=êÏ%Š.™Ùop¯ıi\\IàlÎêå9…–§îÆEÌ£ÂSˆÎÂØGzrì\'M8Ô>f¿i†İR–‘§r	7\"ût®›á^bãg\r89Êâ,‘2N$I‡ˆ-,!ùl%A§‘º4¨¥Æä“áW¥û;®_‡r÷Ù½z†¬a²6Âø²-ë>ZÂjT³\nëUÌR|îÉ®[|ÊV#F€äh½1ŒæôÎ*’”<¦sÛxà‡åÇ‹¤:Är–ïÓ`oğµ¿º¼É˜¦ZÌ¼dn~.‰NCÄ1€§RĞwRä\0SÕ`tê\rúmU5:Føİ¯õ…rJ?}C™mìË”2¹prÊØ:ıƒIMVfÇ$/¬\'İYèQ/1gª¤&\'õ•«?¿»<Ü‹OæLkg%á/IyÀ‡ÙÕ´­¤õÑaáã^Šğã\"åÉ>“ÙÛ	Ã`Ayø¶p8³Û¡>QÙµs›Wuj­å„i}áĞToX¡¾Eb\ZÀæ×‹U\n¾ªØZÜŸ!c¬˜ŒHº]işVi˜0ÖìÈÏTf[QıÇ{ÃD_¦\"‹Ì3ŞF 0&¦âoÀ}Ö¦ÔŞáíJ´º®€ÛsçWœ»~\rœsôœ(ÄÌ|	İ‘ã VãQüîKæ8iSHB!)BSzïzírIgWÂªTÅ›-&;fB†`ÄirÃ=2ÃH–†m…88ˆ³[™Ê=IX-&DQD…F}ée–ZætiØˆâodKÎÛt%77ipù~µz}’³ceuGJ¡Â²şZÑJV4ìîB~&,©î664e¯èèL¯ô½‰	P’O´:VçıS€¬}Fº¶ªÉ#râ[k\\F”,«k¬ÛræbbóÛÄœ›‘äıpã¹¿¨ŞÇº<<}Û×’-”é7ı_![$r”â”â”â”â”â”â•®ŞÈ€ƒ?>†JÔÈ?û8ösÙ«9õŸU\nb£´±•şú²ÈõşX“sŸĞ<©mzc¬x’6©K*Ô\0µ€*Q¶úmo•¿¾©{f:ju:Ø-àÛ×tºìÊÓ_í­÷.‹-¶¤‘…•œJ•2:îdJ\'œ;z‰šI@é‘–‹*FôNQ…{ˆ9×ÈÃ±•f	%Ô~i&2˜Ö\rÈ$İnµÔq8¡Ã\\?‚Pp–[šî`ƒŒ3‰¥J`¦(K{)\r¼VwÄ+HŞ¡sGş¥èÅù+7X-ô“ÀÑÇÙÜ!+]g²8ª£kMA©Z«p‘˜¸bJ”Äå¥nF»!*—+å|^‡sÚÛŒ¨‘{ŞÒJÉÖ¯.ïŸ÷­ƒÅH~æØXlx«ÅİF)EÌÇâÌ\\n Œ¨±†¥-â·n²¦‡)-[kïR—r:\'îóf®hÈ)LÖjû­l–ûŠ¼‚œØŠSRÛ÷<À2·©hc\'8…a*\"¡IyÂf{B™S$ª„ ßñX˜»Q[L`•²Xq²«!aBÄ‚FçV÷ñ¦rnzÈs3¦-\'SñQ6B_Â±X±”öÙß»hr\"½/ÁKLZãBÔO…l{ÒLl)Ô°Çí„Šìë2x}¥\'`Rsiæ×ˆ7CáP%-†\r\Z¥([Û\0¡I¤\"KP´Ä¡¾ß&á—ğ¿¡°V\"ê\n-¦êñï«¼ ?d«âş}W¸—Šcm4ò˜êv–´°Ë-°Ù(Ò¥¥®aM»º´¨Ü\ZÓ;©æ¼Ÿ¦=c.šœ°Ô[lõØ\ZˆÔÆ&C’¹k¨VL›[Ì+Æ2šGõ¤¢\'Ë¸pj//Tçbú1fäÀÇ%aÏ¹¥¹Œ7åÍd(oÚI5ÇjËËÀ¹È²ì\';¥@Tõ•ãú§­ës¾”aÁ£1ÛÇ,ZÔØïÛ¬E‹Î>{sœ3*’s$Û²ä[æò«påÆùxO>ÌÍÇ‘å&©æšè¤§ÕQV7<^I´ÉØª˜¥¼æÏ„7Ø‰õ’:ğôüã9~Ï³fÁ,¥*/œY¢VyÄ! ¯%¡v÷ÃœË~Ïÿ\0èÕÖ[‡š›ĞòÃi@S…\\ç7Øi•¡G¥ô“n¤î+Ó¶Û¿Ñ£5N—TÒmz×fê1}®ó×@ŞÕu$Àâò›Ò3­!‘j`¥Î	\\ÄêÊ´ç\'#Ô‰œÀ9é0á“pR¬J¶¶ßµt…’p	‡³¾²ò#ëC|ŒDÅp“e…©÷§¥íe*é¬¥°{iÑ’Å ôfĞØ½Dªæ¬í}y¥âÓ—xìy=I®•¬Ïò«\\ÂR¡»/y\ZÄ¾³,i\"`».H^rpRgÍ%Å];ûüïoÇj¦k\"àøª]L©]”BlÀ~AæéöRTËˆJÊomkÕrIMMøcêş”Èf(~¨\"ü¬š•\0c$Ó±Á±q^œ_§ãÈä øÎL]Ãı£öÜÕ3l”66%ÆÉîë¾ÕQ½}qÚlyÀÀVL¿d!ór‡¾Ö@ó~ßöÇ~u/¢zËàÿ\0òÛ}²GİZª)ËŒyvÔŸşÍ¿kC{HËÖ\"ƒœˆIî›cí/P‘Æã€ÀÁşñŸñÏ,~Ÿ;å¨Ÿı$Ï˜æ\'ğÕ[»òk¨£xYÿ\0÷\\?ğUeÏ,ç\"ÿ\0‡ñóñÿ\0Ëñ\0~úı‰$ÿ\0…{K	>Ä¤à\'$2ƒDy†d€a1u†¥?Öî„Üç¾>ü·Ï/ùTf(›_×£o1~¿.¿\nÖÜa”ü.fš=öğ‰ÊJ¾²Og]¬zu©7»èÏ’Şõ„‰Ğ²œX´ç§MæÒ2Ã”!¡ÿ\0_Ê°gñxÙ`5?¢3rnT9	(½Éÿ\0X?Ä£ÔcÎÖÂLl;,œA=öÚ‹6p	Òãò[AÓt(\\x(ïÔírkÂ\\§;–ıqÖ!6÷oÌÌ|=NÇH2><âë,(ìqJJÉ6·[×~Ü‰ÄÙZô¹]¥6µ,ˆÕ\n¾79$„/k‰ÆoRL=ÔÂ–#®˜\nöãhVr`–­ì	@—‘¤ğ‘işeL•ÍÄF†FÃ^ÆZæ)‰‰}çq.8‘9ås5nT–Ón—+áæ5‹äî&eÉ­á“ôV Ê2%A}§ÙuAvØá‘©¾Z”›\r&Æ×±»Ô¹9}:SÕéÛÛP·—Ô«‘ÅS!HHF¡N­¯‘Î)4¿Œ\Z¯Ğ%A“\r?qwp@Œë#**qìšÜgÂÍõ)œSK*7¹:PMÔnn=õÛnà¸d/Oœ&ËfR&!#º”áé”òSìÛ¼¥Y#mì\0¨ÙŸœü³Œg¾qŒcã·~üÅ•q·Ïçã^Àè)?Tıûùí\\3Ím:½ŞêÍT«™„¾ÓÛK‚©‡Ãg2œ§2Å%80)‘šzœx€	Ó®ÇŸrô\'òÒ¦bnblˆàyj>?ß^f~RŞ/\'(pÊ>\\B¦c]Ä¥z\n#2A7	ÿ\0J²”zè]ëzŞ¤­mº—ÑêŞ¨*úşG`2Eõöª±&SP½ò&ÉAH*‚çë\ZÚ4a@ƒÔ»˜$C`qdy3-•¯”BTµ-—l„ò‰I²@ó¯²˜tlé….[ìÄŒÜæóï¹Ëe¤%`­JYğçÌükG™ÜfğQ—Ë›ª\r6K_2Ûq	È£e5Æ@¢<üÅ*¯VÛP/PÒÆœ`T” ()_òy¥fa8Œœ©ƒ¡Èq,6ã2\"Zë!Aµüˆ;|w¯Daq“†˜o\Zs»Ø^iÁ »ˆ&#øFcíiÙv\n¤Bíz™E¦\Z\n)¸k†y×ëÚ+{VØp­læ_âû½_.ö¬•\"}°ã,ìÅ5¶9S‰=·»U‡%¸PÔq,¬ñB¡Q¦,£ó58>&æ^o“™äÊ#W\'Ö•iRº#JwØşÈ¨±5ğxqŞVtÂ³ká0ıñ*{²µŠèÃùì2Ò™ı±Ô–¯¥D••6®äQ¶Ø‹İ6¢*©æ5µÆè9óhª¥Í*ÖÈ?9ÙÒÌQoæ\0\Zcia¯…,jÓª0Õçà1»<ææŠ˜w˜ÔÆ—Û *3m¤©?T›ì|\röª¸¾ù®ÍäcØkQËøÄoè›Ê@Ä¾›5×áJì¡<Å¶±ëI³Z\0Ø\ZÜG¨;rt]J?ÛT‰Ù9Ç3İ›C±Ù3$:I\Z(FÄiÍ,Cû²5ËÆIòû²3Cåóß›ÕbàÛkºõåºvÏ2ÜÅXÿ\0µÔî½şu±÷$WÊqJqJqJqJqJqJ­ş¢6k ºåÍ|âsEl%%:m®û-T*©“¨0°œy	nM2Q^ÔxÀYù ¡\0ÒGdQ!ZMJR±î¡è$µ}[iyµí6ëJÙm¬l¡pGP|\rn™§ÿ\0ˆí”Ğ40õ;Ò™c\ZP:ITçT‹G6TI?ajµ7Å#Çlš?qŸ!÷ÏùÂ½KVÇHòj«kW7Ã\\v÷Ô™Oı,‘~‰²‚|\rb\rš¢:¶ë­iìÎâõ¹eªê*v\Zá0™c[5½g‘/ÂVøìqSá‰Âr÷%f§on	€±I8ˆsœâa!IH½ˆñÛù÷Ô¨X–`qŞZ!`‘Âº:â%Í-$n¥úÎX6MÉßÈÔÒîšûg²”»vÏumêYµTí]g¥š¢¦Tlq5D¼ø{‘™ta•Ú’G%¶ PµcÊbkLaÄ”o¬z„ùñJÎû\'{Úß?•y…˜¸•Œ«F÷!@!áŒö‡ÇM‡/LfUí#˜µ©]v{õª?†6¬kV®ÚŞ79Z´Æ¯¨•Ñ;–8åéä	#ó‡)39Ï÷S%ÏoıƒKmî[iHÒmöŸşÆ¥¿—3¬i©\'â\rºåÈ\\é0¢ $GÖ„#J}ÄıõMû]¢µŞĞ²¬»:9é^à°SšÁ”ÜØéu¢¹–êI\ngØ6»WöJ—%«4µ.Fˆœ§Ê¤ÄêP=1tÂñ‰˜^ Ô–U¥Öl‹õò>ãĞ‹xÖ!‹ı,ºØÄW‹$T°ÂÃ‘c ì£Ï- ºèÛd•\0GÃmƒzAõ“Ïµ¤RjSNö\'fZQÇ(¨¼â[S:ÒæHõµ\0×HìR{5²Ê’´-É„ªOï9ÈÍBµ\'‚ŒœÊ.kÊ›-Ç•¥*uÅ8 :µj:|msUº°ì%¦H’°F•3o·£¢6éÚ;Ú¨7©á¦Ñ¿Z¥)È7¨\"ƒÍB¯\0Ê”c?H£ŠH~ÎCê‘ø·|±ŸøöÏ\"y*Ö}Éù†§¶ã.¸T‹¡%J°=NŞïÃÂ«¨GÅÒ,¡vóN4æ‹o´íŸŸ˜_`ÿ\0ˆNKP®ıïà+êSrn>Î»÷RnÁÒ.‡!ÏÛ¢–‘¡Ï÷2fÇ8ççöÏøò%«¾{¿]=<¬*!¨ Vë¹;u­ÊófK*N¥•ëì*…´6ÙV¤ÅØ³	©–@ĞI7Šˆ†œªDz‹ÑRœ”@Ã…YQ“Té`p>Ğ¨PÜ©Gÿ\0øÔ•Èj:.ç8@\0Ã\nIÓº´¤‹\'ßçµV_YYÜ²ÓwˆÊæäş…|;dìFók[Et9lÁ½#F§V	S:ªSqulƒØäşŠã\rÀ;ààf2u¢ˆÿ\0,ñpÅ—¿ÂH6­Ç™±ßÊñ”„¿a9(õÌ)…Ü´OèÔT«{ë]»Ã9µ¦û<CoÎNíâ,81‰„9óÆ|øç·lş¼Æ½?{™rãüÒgOõÖûü™­sxõ†x_‡¹ı×,>ÊÍâCÿ\0~ác¸³ß\'$e‡˜æv¯Ø:ÔÛI>CÏÜ*JB*H«\rRé³ñ¦ë»KËÄf=Zø‘¾[¸6KùGx¦Ò™—’	ĞK6–œ¢\ZˆqPTnœeÆ#EÇŞƒ­b[1L‰2C.økKJ§´è3iDÇm\nU‡ydl•Ş“ş’x‡d¯ äÈò^íÓ\ZÅ¹e¦¬µòş†z©Ç([–°V¸\n\"<È­¹²é-ûk¤nXV¸ßdYÏÀ%g±	å½liZv¥\rÎş\r\r)Õ· @„\rªÂR`Á€àFs!Ã›Ó;\rkK-öT¢k-ÃV -Æˆ[—R”C€jÃé!èÿ\0…^Œ˜,d1Ú‰‰2æ+Ê|·ß… -rR5†õhPuWÖ¬•³N5ÊšX¸³cQ‚‘X¯ˆ¬täíµ«¨hŞIy{qP&Šù•Y…‰*<àˆï!c9¡À‹2WââØDN|¾ÅÉa\r¥ÊKÉP ¥nÌ}$\\îo}yïÂnœÕÅŒ¿<ì-÷&Oe/±rTô~S©YmeK²Ài¹6¹®z˜%„’g«ÓäÑä7áAQ³9å ‹Õ[VªXu ¾Fëãİ+¼‡\'X;ÀÅæœîÖ¤Ìà	ñá‰9‹¦>1K}ËÍbŒ6n½‚ÊRTûì£ª—ä¢b’7,²îëÓ¯Lì“˜8{Äl¿Ÿ°t;<˜Í;¶n¤»\r«N$ìÜˆh,¤nùH¹+¬>öÄùKáö{e.®–9!³ãrÒ€ŞçPÊQØNY}3ğÈMD¨3‰\'&5!¦yyå¯›¸\"S¸²˜ºš}•tq&ÃMº-\nIP «³ò‡¤Gó	ŞÍÌË\raĞØZñîI€óc¿æI¸V»%¿ RMfN‘Ğ\ršÚ½í“Z\Z‘±t&¦İ\ZÌ¬ëûÊÀŒÈ¦u4Á2Ö\'¹\r=qNreêË%!æ¼¸£ÀÄ_ÔÏÂl˜FTä=Û–2ñË81š	!)õŠ=TæÅ_ NÕù×ô€ã&7Ç$â˜ûm\"LT;Êe…­Àˆq›:X7¯KŠ.’Tm~•µ\0uÓñ%µ«Ó:h[ñàïŒ¥yÕ‡fcEŒç¶B/¤2xïûöÎ>9\'šOzß/\ZÓq1-	õøl%û»DØ¤ı•Ö®)×âXÖšºMe:Aúî;|AÔ¢•t6Ôc³Rÿ\09ÉÁ–6ì6²FHê‰l˜´}¿²§<aÁ|ú¢T°OL8Ö_Kªí¹yiŒNëˆ…‹ø8¶mÕéÚ7º|«jgV®­;]FD¶>¯éIl\rjúìşÒk•K´mQù”zC\Z[ô¹}ò>¹ir/!rœÌˆCNbs±æQÅç34!²uşÛüÿ\0“_\'â™)êf9¤$]k±Ê\'Å R‡BtÚ¥:›u	Lq¨Üzn!r\0¥1*U\rVí6èÈg©?h9!@îZa·–3öcûÙÇ~Kô·¿o²¡Kù5mön*—mìœsíåÌ\rí·—º¹MeÕÍóÜ\rÜ¦wÛ¨5m^kUi«Q©úMRÔÜ§<Ñ¶we·É ·-©‚/ìü´	§ÈòPÂ@ğBoCÔQ\ZœHE‡STënÍCÅî©º§Öue¶öa±½¥j=Hé}„ù\"¾ÓŠSŠSŠSŠSŠSŠSŠWØşœRµ¢üTí¶ò›±Wªè¦¡ÂáÛCKJîe.èÕ85´EP¯T–,û&DYgkIí&<Af”şEŒ8Î99€•ô<–z /]¯eD‘d«öWm÷­\\½5Ğ³S%\rñËsxfsş£—´­¡¶Q °®\ZT¾—÷r¡zôª\Z•Rv¤ğ`ü¬±àÜ	¤<F‚ƒÓÍ½º\\U+ç0OID¼B[i\n?™ÀuP\"5Ğhc¾á@\Zu©}îºEXåo ú/O(k-7Ö8hĞšÑªm¥`jœSù\0â^©Rã? ‚v3Œş™Ç$©\'­R\'ÃÊ‹!Å+ÚSË[Ê_Ohº¥y||Íb¢Hàİ8\"ôœcUO­@Ûs÷8CKE~sXcLñ8ş$Ò·ƒ÷&4â‘gmg\'\0‰¸059%ŞZñ,b\n†Ôú´%×ØQ6\0¨€	>çù½m^pÏâf.ö‡6¢óq”–`8\\ä¤¨¤6’Ò÷)º‡€;Ö¶!8¸:EËeSºP¢…]9÷Ñ{å¹[>·¼<C¨»½BµNc9Ú759Ñ‚9B”¥`Ñ‡èÎ-¹ÀÖ,İ\nÂ’7½ˆ#ÄÁ†!Må,Mì/Œã‘ÛZÄr‡y‰	QJÙ/j-¨şˆ) ¬u)(±×ïİÛËgõZ	¬’,>x­¾[eÑ÷€ª}YV#©1pJ¤ñ¦B -GÀ0£*D<˜/âN52»?:²c³\'ÁW,0ìG@%n· ¯om°5„oK\ZÔ½\"Z×‘C˜PëŠƒ‰)fpªdQÔ³·™ø_p¬Á+F¥ìò³‚<	ÁD•âË<§ş‘á$îå­ç~¿ÇáVWsÖTSW„iÙdê7ø$\nçïËªÛØJ·QjY\Z>ÈÓ§”Óİ/shu8çI‹Cüìùâ·¹6š\"ËWƒÏô0ø	^ˆ0,ãÌYçÅfL%<Ş§cm#øÕB³ÎQR-©bß¦Ô½AÎŸ£î¤¶“¿R¢/`@°«€‹uîÛˆÎ5m:ËL«nªƒQ†$ªK*Ä}CaPöXÕ²°•!Qƒò2ÈAŸó‹ùAÏ‹Ì8}Ç¬=7ê~w¾®(âÖ­$>ï(7%Ä¯êe¥\'F‚têñ+$^£ÆìuaØıß¶I&º÷ZÃU7ÍæxC‘?«Hj‡ZÊ5X}4U;#Ée\Z!VßÏ\'*8Ç¤ócpÏ8o‹½%Ü•?°¦ÖT/ß\nºwÜ\"°~ LáşpÃša¹2b„<—	.%Ò½ˆ±!´\r¯µ’=äÕwÊìû6`é^98@S—^È]$i¡tpPê™9¤JF.ÁÀR‡\0ÈCŒıÂïúcµ/8·P!¶â¥¶kÔ‚­*u@Ü“áaÔÖEèıòo£îz‹Fyxƒ±æµ/’ó¥´,6’4İ)Uµj;ÛÊ²06*À1åR§Ær à¤¸ñÎEŒøàXÉ¾?§ıùÇŸğA–“¿ÒNö‡ïnµëPü°Ğ¢YŒÔ¤\0…\"ìxøx×ı#Õ“ÑÉJ]‘*7?1eIä˜°YÃSz IÙù4E„3?#È…Ë»¼:…‰°Zs¤Øw]Û\'dßHŞÃº5…a8gå>á‹ªd,‰„35K.*Hœç8­d•(^9	Q;ë¶®½.kîp¿¥ë«m_NBEÉÄ•Q9~û!AY(âŒJÎ>qş¯%a¼.Âğ‰­Égu´­ZùV½KøŠÈ³?å\\ÊÙ¿\0™…byF#Ğ&0c¼Ò±\'AR;Ö&7µ{)% ZÕÔ[-Y3rægÕ‹“á‘V¡°EBàğĞQlmgö4Ò‰1µ8ávÀ}ÊŒš£ ÆCê|‹¾Geh™ƒ1•‰†Z+æ(2Ö€µ_½q«p|SÒ¹Ï„^˜üàÖdV-‡e(†U”†—#R–Ê?XZ=ËÖîóHNŞ&²wœÚBcp)éÀÚ¥[†I0ŸÙ7£\'×Rè¡f	Ç¶~Á@ÁbDàÏX0>\rBrgæ8¢Ü] –µ$ ûAaCIE»ªI6±5Òx÷å\\Ê™Ç\rs—•cInZ9|¤ânê¿T)\ZX*B®ø;ZİEYÿ\0J7oW«,™­¶;-ŸK!oì½í©”ñîS;¼ Åäè…”È“ÎH\"	.Y#\"JÊ˜á#p1\Zr·[ÉØv[e)Kq®Ñ<®Ï1ĞŞ£s¤#»ñ·p÷8ÂŒß\nF€Ç™…A”ónâÁéê˜%8‹”j:AĞ•´\'Aº•á}İö§¦6˜n*º‡Øõ^!K)tH\Zé‹u6´©Æv²°B&Ú(\0´\0Çl7ÒàYå€¥¹ÊÔµÔŠÓB%i\\w†âJ]Œ­Óäà ‡GšW«}ÁÔ(ÇFKhh\n‚8uˆê`áIh{WA°#h¤Y@Xó”Í_Å\"\nú\n>ß?P}»‹>\\¦)t›ëUVı3E€‡¤ÛI}84q$Ş*-“ïÑcÖ½ëº@YÒçEuêmR[È)TRÄ_µ²ËA¹é\"òH{Å&	hW\'û`ôŞ¡^eyÇ~T¸J›¥¼¿ŸáR—™b¹ÌN!Î_‹raÇ\\woõVÚBt%]‚:ßİQ¯ğßÅ¶\n9µ^	ŸÍá6İvEï	`v¸êÖqEêac¤ºc¿×1„D’ÜIÆ¤9¤™@X\n—¶=`pè)Û{oU.>òÜ-¸ËL8ò›Ofk_õLƒìkéğ½«m.Øş˜ÿ\0§$T4ı8¥yâ”â”â”â”â”â”â”â”â•Š¯*f½ØšzË¢mv2¤•µ·@&¬†g\0Êèü•¸m«ğœìà^™àıTæã\'€³Còsè%& q°ê\nOÜ|÷ƒb=â¨?¤ıÃikõ‹ktwÛ—Õî7®©¢W*Õ‰ãÎOSşºBzÿ\0BşŠBv|WºÆÂ ·8\'À9*bı¶@?¥(È\'õQÍ2ãk\"Ï5fäÑGú¹\0tÑÔ²ïâjÎ¶[oµËQ+‰µ{Y±Èãl#êøzv‡KAûª‚İf‰×„Ÿõ5ŠİUÈq‚0@…‘iÅ¦(ÓAK.lHM-n¸”¥	ÔnmáÒ®ø[Æs.$ÄhŒ¸µÈp4Ú¹n\\5wRu\0v\ZŠ•`›’+Bí¢Û+·¨=úŞº–B©á>¥G*HŠL0ISÇØ™Ñº>J\0¾½\Zjc$’Eb(¼Ff\'iDƒË8ö;ˆñG3·‡Eq,EJ­ÌQÒ6ö•Ôj÷yõ¯pøCÂ<¥èmÁùÙ»†ìÌE˜êx†ZBå4‡-ÊcPÙ/>¢µ+¸Ò‹í¼ éõxßÚo¸öœG#•ŞŞTö­¤ÍGßºéfyQÎİæÌíêdsÊÉ{º\\!5Ö>Ş¤ÄòÅJÓ•Å½¥Ã\nÄA\n’vîLsÁ1c‚¾µÊa¶¬KWTÛê÷önoï®ãË|9ã?İÏò ÆÀ\'?Šªœ\Z>—Ìçœ\ZÛy”.8ò¯ªbI/¥hRk#õWü6S\ZÁŞU±]0.—ÂÌ=éöu©Š{‡èéAU	Ub¯;6€>b£²ì!ÀP¨^^Bœ½‰#‹,÷ú~æÖ-µ`BäFJR¤wä±¥@›•< ,.«Ú«¦æƒQÛÈ¡Ê%bïÍw«—<@å¡kí½TºÄ&­å#Sè	TbG2|jns§5)qí× î)Iéÿ\00Väe¬·µ‹¸×ãåXóœ0•‰EçaÊ‚¸êpİ|ç|n,”°l<mV™6ĞÃå­†”×~õ/°l¹[JP¥|‰S®ñWq:© ~š²\0’§>š”Ü™ß¸~¶ƒİÇñß—\"æW\rGG‡¬ïíïk‘Y&N|‰Œ¶…uq÷!¶|@ejqÛ|QáÔŠşRNÿ\0\n-›ÚW@ã/óƒ6Ìí“<~L€\0‹çíì›ïûg–¹/åõèkcı_ãkôª1‘xv‰aGŠ§z©]¬†Éıb€Î¾®††ü26‹EİÍ¥×•?Ì†¹ş%jõsœxÖŸÄ{®q•Äã·ûİ»ò~Œºó`(2}ÂÁ[1â=õsc†8V.ˆ˜”9*^ÈĞì4hÿ\0¼ïn—©‡\rü9ZS{ÆÍ±õÿ\0¨ì–\\±ik¤±˜¥I8jn5L8/FâöÈ±Bq€ãKTIB(¡zƒ(!äQ2Ö_e¥êakÖ6<İ;umºjÀÿ\0\\„ç(¿ßVÀ©\Zõï§Õ©§KFÊºTGÂõ¤\Z!øz)€+KªtÊxä•0½vz•Î ğsÀKÏŞQEWÑ‡Ó‹4yø,E8?×ëÉÍ@Bšˆ¯¸µm¶ÏßÖ¯qx*0Ö‹’¤5£¯ç/ÃHgàÒ[¾ë\\„nàü.õ»´KRm-Ê\"Gä3¦±›ÁûMÀ¾å9‹Ë2O~¹Ç gîã”h›—uVq†u\\Ø\\ö@î«K™O†I—wñœÔ‹)ÖŞy°¯öc4‘µºıõõH6“ğÁM“Îó¥×\\%6IôÃ\'‹WSæ„XÎ3÷–®5,9G˜qóƒ¿ùsÉª——¤#ôì¬yOğ\n¨s.ğ½A:1Vv ¤‰H¿ApókJ½÷¸÷T\\”×?†a­¡Âpß·›ín	4WçCÖ8¹»	1~H:ˆ(õÎÈ±àXÔ¸úAñêœc¾*Ú…†)° ÃD{@©ÆŞ;}ªù eüM€ço€ói6çz»#}ÁĞÈ\Z€Ü‹_ca}ª³u^¾Õ—iÂ»m§÷.±h,©ikÙÛÒe\\şE:oLüVc°»Vg	DIL‰•İk›ÉL™FG§’[Ó¦B°»D<ñ–_Ä†Ì†cÈkº¤\'Õ\'­¬I*÷ØÖúŸè£Å|+ÁÅ àçèœA¢ì|e¸í—œaC£*AYgš=—JBÕ{‹Wé›¯DĞ	)ˆ¬(« ¢¬H+ô´Ã£Å~ÎÈz4h0\Zqa0a<JEïO8c9VFq‚24fà‚<4ô­R¬üóe°ä}÷\n*úÊÔ±ë	#¼ ¥øÖbïÿ\0ü×ÊñÉ”ª ê¹¶Ö59\\Á5SU@Tƒ|7…İEE¯±âJR¬Ø,MÄxiµ/é³ÿ\0îM±–ÓÎ4…ª2p»¦<ğŒÜcêzû‡ZœÙLvTúÆ ‚ÒUÈW°=éO¶²6­ªÄô#Lë­Õ:—V«3”¹´Wl†}zTâ¾µ<>©ÔŞrøixÆD¡ÉÄãÎÆæ\"ú	¼ÆHZŠÕz£a!¾ñÔ£ŞZ¼Ôw\'á~ê˜œ†§SŠSŠSŠSŠSŠSŠSŠSŠSŠSŠSŠU:uyéû7Úªò°Ú®ğEyÔOŞ³u’ÅK€¢[&-!bU)¢dnaÈp&i1Aô<z„³ÓóÁi”®Èãl€­üv©jyø›\ZŠ6q¯ÙúíyêŸÚÎõ«ÎÎëÜ/¨]=2êÿ\0®ñÇì_±ÇVÈïQ}E}Bí#²5òËƒ³—½Ö)œÊÃ±)[Ó%ó˜²ÓœÑîWµ˜ZÄNÇªøŸ’çc°”ìgHi&Éq7÷ÿ\0=+¶½ı!°.ç­ãQcNË“œ‹ˆÊ“7rÚR¶JRAmµ*Ï6»õsEÈÍ§¤m²=5h «×¥û2ºdïÒØš@LIK®´ìõ_µÇkV™y­ìŠ~­„ír…«rKrh„Ö¨´IR¥*xk9><hiÍ²í‹ÙÔ»ÕFãÁŸ™ÜÖYzff9Ş‘Òq\\Z[˜†PKÏ@^¡ì6Fh@¬h}RN•ºúî«Ø·¤\'xuØ9OÖŸÒhıC»Š°m˜ÂNÓ3jNK4ã\\5ä—Q”qhò´%’í0V”ÕgâÜÕ$	\r íjÌ¼Ao%†pèvŸˆ!	K9¹Z¼	èŸ*ØÜ ô_O¤¶+;8ãLœ½–œuó‡á--mÅˆÊv°ÙRÎKBòä¹¥²¥¸¸©yQu¦êƒ­çÀå÷ê%{%MØŠÄ]U¹R‘Q;DØg®ğª›ºáíÈ›–«$¯3²¦PÂ\"ûÊøÿ\03Aqcxy‰a6q HI\'Úq=@$ü«Ç}}sö\'/Èy¥©ù\Zİ&2eSÒ=bpÕíb™Ò¢´·mVîªö½ÎŞ\ZÓ¯5Ã²ÍÌØç2dêšPßğ&´qk®#*Š‡é;mycDòsAÂÁG&s(ìˆ¬”©¹Ä)Î$Üîbl@¤(-·\0PRzÔ\Zó›0å|W)ã’#x|èî¸‡IoHuI*l—Ypocr\nûUª>Şt\rêC¥KŞ+H\"}¿ ˜²k’Å@œœM›˜<³ŸBMSäß¬¡9aÀ”\r¼§D8ÇŞYı¾9i—!âdÜ”ªß+jk,°ò5ÍÕ`›Ë­Øî){İhï-¡~ºÅ“p9‡©¦ÀNØ½áÍoØsŠHS‹\0TÁ\"o\\ÖäœYqØâ•\0|±ÛïEœşİñaÏeLj:\0[wëÿ\0¥aÒò^+ml(JhXÒ‡Ş‹êÛR+J°ŸQ:ÄÇYÆ\0rvEŞ%øç¾sÿ\0~Y…)·€-¹ªşGùğê+\\,M…lº¥Iû7­Îz9œÙÓÇ©{ÿ\0†Kú4];‰¦\0Œ‰§LO¬0‘Œc¿‰dã&gcøÈó‘g¾w„¤rØŒ<{#~Ö‘[×‡Šsú&Ş¥¨ÙÉ6ìŸXN×é×…io$AF€AÀÎ\"Ê,–`½vğ?»çç=ñÛÿ\0çšmxv,êÜ3Æî*ÊÑpAQöáZZp}Ù¯i\nsÖ¬Şú“í‰ğ5Ê;:20–R‰¡¡Œ¼ï–z Âü‚<5 õT|ÿ\0w·§ßË°sÛ9åÇÈ¸Ä°èDvÖx÷ÿ\0ì\'¼O¿¥OÃòÆbÅRãŒF^–Ç¬æz ”ø›¹¦ã~ ôŞ³N›¶åñ|YlPVÈ85EµavihjÊµC¨Ã‘3¾~£%TX;Œ(ÚQ»¨û3#s€ó0‹—²î	K[â”’¥»ÜdAÔµxtQ±±òw¥fGƒ\r6æ)%@­\"«—„ıG&¹fÒ¿ÙJ»Çdƒ[3t:Ó—¶öüäÿ\0(îÎÌÖP–iürwzWfWt	¸BğÙúûLI²[²ï¡ŒÔ\"5ÆN„œà¥eªBÚŸùƒ\r\\<ÃdöwØ|2t(2A\r\\l››VöÌ<Î>À ?‹@vYœÅÆ…Éz; ¥V{š§Üğ$z›‡»UWÔ–Œ_¤›w±Üf<(z{9,şµc$*ıoàÕâe1&ö‚QÓìŞäz¶<adå–1ã›³¾JÃ%g)ŠzOaæFí1×õy» xß`oçzõÏÑsÒ4`XLhØYÌnÂÆU‚ÎŠ5ÆÃ$6¥Åó@?Õ¡ÉÜµ*KåÖÙ“\\»_l{7\\\'â”+%tzÆHÔØL§©U+ŠnDÓ³„®ŞDªöFy” Òúbøv?ÄœÊ:]}‡q·RJT’{¤ıdƒ¶Ÿ0o[ç4d?DŸHça‰+	¶ÜÄQlÀZF·Û-[²©Ln™+`$jë[ôƒ¸ú€ß0‹.ÒÜ‡6é-a..$ë¯RÏÈq:ÙÁèAP½¾h&ìotw%Şz7‡g*=¨õ-¢œêŒ·3\Z›†¡Éì\"3Ë±ä£ê‚.	÷‘ï¯xá‡p«ÏAÊ2›‡Ã—\'¹«—&JTuò5)ZÚG@ğ°_A²j~m®ÕSúQ¯Óí‘¼ÂÕ	‚¢ñDÖ@²)òd¼¡†%[Ã€#\Z—g•!ÂdÅ€Á ÉªÎğNœÓ‘zÔM¡+WyARÖz!ªà‰5	zOêÇ)Ï:¨os(îÍ³Šª«Öœbôzw¬*³ïáô¼`vÂW¤¥o£À0§ÏÓ!H‚¬Ç[ŠKvIğX\ZjèˆßÖå¯;ÿ\0LñÜíİ\Z½şJ¯´â”â”â”â”â”â”â”â”â”â”â”â”â•¯/PÍ(Ø_¾Şº°ôËd1îäÂ`Üİ<B%	ã³_¶)FüŒ°Œ`I4dKüôG¥LğŸÈ±\rvÒkv&ÇÆ¾7)PÒ¤,)Èn/Sí$]m¯§hbçº ­HÙÔõŞõ7µ‹sj-ûÖëUe™|ÌBVÍùu`}´æ°¶\nŒ((ŠşrÂ„ôNˆ—ú`+à%+\0@¡ƒ,XÈ`q\nBnºM¾}*µØÉˆëJ.ÇYK:Øõn·pINÂÄtRz¥[ºé\'Ò/\\\Z6cfuÚ¥²Œ¶Ová µcÎ¥˜\'ùyUÜ}Êm0ƒœ~F€÷g6ß§=ç8\Zƒœæ^ˆCç6ğïkâ6&ü›—\"¸µ¶Ú·»ºÂRu\"½—ôœâ^/“ırŒ|å6Ö9\nYsY°Ñ	q”©-…iuõËaJ*ŞÆ¶KüC·t¤l:ğ´Äb³¶\"Ï¯V°\'$°SR´™Ôéa(@F½!	™ŠÈ=3‹JNr\Zm^(bpğü¡(<æ¡M§W[‘²‡í]@ıõçï¡ÖGÇ³—0Ckg°ÊCêİÒ”nâ9–õ`´ôğ=kZJæÕÙº»Mv\nUDì¤Ö‰Ã¶?U–É#pw±ùLş}g#’BÚâÑ	l#ÚJIñ53’vÂJSÛÛƒÂ2†+ˆCáA’—KnG+Ğ§ÂÒ‹mït÷WbzEåü³úqáøOÑíÌg‡¹¡I[|òYRÀqµ¥.!ç\r®÷\ZªNT=uº™ÓJ4—×{3\Z(âˆÀ­z±D=Ñr…z`ÛU‰hH‰ä\"Vi\0=)Æ˜çŸ’ÁfrNÅ¼qXRfIÃÿ\04+2l›ßJËÜ7ó¦}ôá(ÎÇ,a9†s »=ˆu¹/²ZRnU©VµÈ·[m[ÑOšÖ·YO¹6+U*W)$	ÅŞsÅ¬Vô+äµ••°2%XEo4”ÖàsB–£	vD¼\nIÀ˜2ÔJ„ç›ÇÆbâø{R˜]Ùu:>^7¿K{ú×˜<Oá4Œ…Âç°Dè«	v\\\nPBù%)pƒãŞAum@:(~® á™=é5§.JtSy2äô\rÃ*Tß1ÓÖ)™Y‘[i½IşÕ@È?	Ö32Œ\0È±Û•\nxJl S«ªlzx{¿\ZÂ1l‰`Î¶dHšĞp¶‰)!²àYMë\0x»‘ÒÕÖ-ßÃï§:oSÌç¶/UµÖÚÅKsÍC£ûlYı|€‘150;6GÀº¨Œ)I°‰A£LAãè~?$¼…;ÍqD\0” \\Øl=ÇáWl®x†À\\<>T3ÍBÒPœ-¡t¨i]ÊßÒ/}ÎÆç­@k«§ŸCMˆëÕ5ºw¯wX6R=5’Ò¨ég¸Œv6ÿ\0¬F¤ŠW®T¬ôD§p<\rùOƒp¨€Ì’À,Ûq¼ÇˆÓ’[M¬“t›°VSÃg¾%cîa‘¥´ÜÆm®<(,¡Õê¹$‰\nVŸ¬àX·©\'Ó†ÍéĞÁsXÒØGHjÊ¥«éİ~·¯œZ–EŒñy\\hi–2İU:IKÈ^ÂÌ%ƒ)™9©M’Ü–¤	x;;%Û²şs…™#I}E¨À\'_‚ö&Âş:Eö¬ó‹Ş‹Sx>¬\Z68êŞÄq%İ†¤9­H¨#šìt(î /¼mÒ¢¨Ã¥_:€Ã¤;Y=pA&´I%æ¦n\"«iøsA³dTe(Øé\"i\0	ö­ÁZZ3Î2ììyjøŒ:Ë-ÊOsló%J0a,E¹J ­\Z—Ğ¨oãµ½õÜ¼SË‰ôSôrÀ$`q™c2cÉH“‰®:T(Î /K<Ä©¶äí#X$–u\r!Ò«¤¶Öƒjß¶z’Ãghr>¡Ò¨£òkxDšAÌAôô)É¯Ç \\PÔjr5‚P ²\'#a£\rÊ9Aõ¾T.iÄ Ø{\'¸Rv¿Ê¸İy‡ÒÒ)~2dÜa˜êqØÏÉd)õŸZ•<„‚ûh¶¤6Ú/ª× oP7­L¢©Ù-êG-PÎ·caíé˜£$Ğ••JÅN­«dˆ“›ÈËˆŞ˜Ü¬i	÷(™^@pÌS‰±šiv\'Ëçrhò•ıbè-ã{ƒjèB™ØÎónQTÁ¼S›Rï¡˜“#¥E2\\$PBÔOªïw®«ÓZb¸ê[¦úï/İM+ƒVy£–²kÛezó0ŠÀåA±æÄá’CZËP™Ğ¸»ç¥„+ZzWq6}M)†¢XMÙ¶Ö)¥¼ÈA+å¬ËÚéóµ¼ÕÅ8Ô•dìÑˆGÁ1I<¤™_—ë\"sn]2ÛKÉH/DyEcWqjŞê=jÓö7ciE¥e×îÁÍÙë\Z‚¾B“ÏjŠÇlodLQH«2<y«pV,3{rRÿ\0§|œ£Ğ\'À}•‰GaR)óRÎ”!ª”|‘¹ê|75Rz}¬÷WTËÖÔ“}á®õÆºV®™:|h”œ&”œBøîÔİ)¿•…R2ÂR¶¶õ$Œ´¥ä£<KLJp*-IJl:øš¥vJ&§’Òm&êZ‡¬œ¿ô‹Øƒú&ú.Ágö¶NÆ?ëı|ò¦×)N)N)N)N)N)N)N)N)N)N)N)N)N)^3øşœR¨/tº`ÛÕuÕ\"ê-Òiõ ÛÅ¤{«ÎxÇ§@î¬y¼ ›ˆÄ¹„ÃÉDË#KòHüœ$úÊÅƒT\Z™Q†8r0¯?vÿ\0\nF–¼1[µÚ¢+Q~ô¬ßúÈR÷[eİ¶äë§)¤Qïç/µ4È·½>ê\'š8Ø›ÓRÒš¨©/X5ĞˆñºÉn½S±]JÑ±Øgû±3ä&ÉÃX~N•VS®sMÄÎ\"q%äG˜â4¼[t—¿²z]_Âº÷„Ş‘Ğ0<•ıÌ˜{™¯&²øËlY¾]R°øå®é}\ZMƒilÚİv® ‹§‡Tı§¼TI.ZKedV[àÛØd–ÖÍ<6FbÑØúC¼FIRU\n‰3iò3ÙÆ*\Z¡ü”AƒLÆ¸‘¸‰œ±$]ÖZŒÕ½‚N½ÆéHñ·Ê»\0ô·ôIàP2r^‹âx”ØúY‡!„Eq…ö™/«»°¢Š²Ô­6Şæ³GV\ZB¦Un“èœRk™ÄÑı£·;!$	ØÈ’Ë\\YÔõ²£aÅˆÃP7¤$n	cd¤Ó	@€ÃNŠ–)8w..9,äø¸dp»8¤¶Ø7$€AQU¾²¼~ÊÃ}\\ÍkôÅ³¦7ËuØÍ=-Ä¶Í™ošÓ\rE¾éD~êB¾¶’¯­aP±&2(úê¼ùjpÔğ«?óqğ1D]É·â°ó«±º¾I\'å*5K°™ ÎLÜAËÖ-¨!ã_.f`™…CË¤ÅSÊK©ZÕt­w}ÛZàoá]…/	áÄ,û˜øÀg?#\0&aƒ»&;Ñ\Zy½wïòî¥!!)êJ”v­³ãú¾ñÓ_¢Æş<ÏÕ&[hZ”µ>›´°¿—!a‰›*®ST0¨»,‘1e–´i’*\nåÊÓãÚšµY¤£‰H(ãz^ÖXÊÂ#jÔaË¯q­V¹µü/²Fõã/x/\\s8ã±ÌVçÎŠÜx—³\nKh×¶Î¬wê®</ZõôİÚ:³µ-¤­Z45ÀÛjKøµ€0>TÜ—Øáåà¿@9T°©-”´YHÔ’\0¬39Ñ&ÍïÅÌÁ”¥%©ª*`/Áa{|øß¥z±é©èñ†æŞ\rDÅ0†ZsË‘YbW(¡\0°Ûhæ©A	ï¸ÙÓkE$ÔøëÕ·¨6dâ\ZÏ^Kd´Æ¯¡E!*e5;„nQ±–3Hb$¤dE+z4ppVÈŠçeYÇsIÏ§~ã~bz<TBgPP!Ç”Ù±m°Õå¿ÜkE~N~0î3#3âÌµÊOæP’€®dµ%D§JöQKaNiàX’:VaÖÚâµ]7Ékz²õ¦Yx?VON±ô²I$BXÕ^ªñ_/4í®…{ô†!…àYV/Wös:ÂYg3ğá€ğ×ª@¾æí…iP?!\\ÓÇÖÛá¦4¹¦»3[jl”rĞémÇB\nF•…vİC^\n “İ‘“P3%(\Z7OU¯t-b²ÕªVÉbdØˆğÚ‹ÙÆ4Å¶+Qâ?\Z<ã°üAŒg\\ğ:jœ‹‰áÊ;\"Ëµ¼nZQû>ÚìÊY·ˆeÜ¥™ØO¬Zt,¨ôB™º‚¥o¹Üõ¨5p¿ôe@O¦Ç±:e\'l~h]• f’ Æ•ˆ\\Ÿ©c˜Ç”›”ÊA‡	]KTŸ99><q\\7†Yö@’Úû;…I×c¥Hu[8<´Ÿq7­Ñ3\rÂ}5=à5‡Èhâğš`ÉŸÒ±:#EŒ¤°u½![%GH¹ ß³îÇUmÛİßbum5úÄç°oÒëOaàw|1¡©’¡ŸÈ°„e0B¬ÒM5[øV¹‰Ç!M‘œ™2a%„\"®ÜK8.j[r0¹—1JBTËz•d$÷z›nzu¬Ñ\râ·~’…Ø…†åá¾¤bsc·	æ,1ÏXâ”Ğ)K	$‹’;©­˜ziéÓ~Áé%YSoÆ³H†Ûªw„‚E«GX­îğ…n•¼™¼™\"Då5¦=2÷•+ZÖ±Ò| {FJAI°<ôËø	Îh%ä¡½M›) 	÷ªß*ò«Œ8¾YRÆİÊø“ïá2_†¥ÇæED¸Òy­\rõ8ÁIåİZyƒ¾@¬xºkÖ‰54ÇeÆ8Ù»4N…\r!¨U!$¼Ş6Ãªã~—BÃoƒljõâk’‚2b‡í‰P ®dI\ZjäFj<>Ó!i‹\rŞr†ËPèË\róİN‘Ô›TRÖ.œ{	¹·{º¾™T‚\Z§ó&­t÷d;ê4¦­àã†$’\'\04iå²óJÂcÍ1h!	àìfM0¥A\nÜ\0X}µHì‰4”òK1Ru!—\0ç¬íg$«õ^Hî¤+}«aĞ\0 \0„80`8ÀqŒc±Œc¦?Ã’*e|RœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœR«³{z^jPVØúÛ†2ó¶àŠpãYì=Hğe{zW®$<#ú$ıœ8Rr2Æ?WéËr¡G÷€¢ÌÏ©È’µ$øT¤¶ãÑ!‡\\ú\rÃ¬5\r%:I/7ĞèX#akUU8Y}azZû4×ıp««~¤´†ÖËŠ`kr -¨•d´mšìÏpL \"#À\nU¡ÉãÀJÉ‡¬(BûÊuC{_à:Ub±h²Š»{=•ÅöÈ-©Q°2\"­…x’ÅĞMûMMz[¬{ùi[õ(«&7\r¿aÊgOZë¸L.µ¾Ã²ÈÜ{n¹ÅZïx (N7ˆ,‡¢N%ænÈÅ«s•˜ä		œú\\Ô”/¼ÊoàÔ{ÿ\0\ZîNz^ga*eœÇpõ¡w€²ÌÇ#$Ü!N5­$¡*îó[EˆïZ±¦ßt¹ÛB©j»Öã0JØİcêàwkEzØ\\¯ø (Ó¢¢+§+	ù‰!%=\"yd?Ù¹Èòˆ°#Z™9Ê…¬7ânMÅİDBçK„…Ç´ì” AÛÆõ´=\r}\'rŒ,Õ˜2Ş:f§æËŠä·“KÁZØ˜öè\nÚŠ½“©W´‘–¿Qh5¹ĞH­wq±NwØ%v\\3SZ\0K²»&WL˜,eÎ…º£Á¥\r#|\rKZ\'gÌ\0~¤@H}eDƒ9æ?)9Ë}+aÇXH_uIrİàFÇ¯{Â÷­“øV™~•éÂğ‡cbĞãbáâäWĞúUNj$µƒtw‰öR7$tª {¬šCM4ìÌf`cî\\¯	M°Q%íëÓ§®&9 ìëD­³ŞğÍ2‹´ªF!ãÌ¡=7àŸ?p¨dPç<ºÛù[ÅğòKĞ’Ö²ßR‘ŞUÇšM¾UÜü\ZâÖ#úJg“šR–p¼Ï2bğÖå+J´§’ˆãU€šÇu\0¤×ãCÂ`š·¶‘:!‘¹lû]yJAKÂµìC›XwÙ‰ÁŠ@åj‚G8ó<~‚u„b8¼ŠìK}ŞÌÄq;dí+ßcËE´ûÛ+Âst3ÒÓ-e, —Õ—²œ©\"sIÍx ÚÛV nèaµrµ«f‚zŠ½Ş‡{O©kÍí­féIÜ…Z°Pª^:Ø¥LŠŞi®jç–{©’.³%á!Ï*QÎWÓ„w»A`IEš0ç| ÄX—‘ØfÃ\\~bVöÔuü«›(^H—…qŞN*¤¢bhŒµI>Í€ÍìåPÊ©»RkMÍ%]Mwj5j½Ë`ÒF‰Õo!ˆTrë\Z&Î©qå·GÜœJ\nçB…@šÜ‘áØ\\3œví€d¬½šğ¼æì¶c)¨nºën…÷IB”{Ö÷Ü({«¡xÍÆŸG\\×èß‡åŒ[3Ç‘Ãƒ\0²îËÒî¶İgœÚÚyÉ³NïİRSá[­\\?h}ü­é™äR†Eö)oÌ©ú¯–,†ÏáÒ%Œ¤«”À±1ŒĞ95$^#Â\Zğ¸“îQ‡>CúÅ²ö\r\'D¦òR®éRwqÔok·zò¯\'q:ğóí™Ä°wMî\"HS|ô}TJoÙ{H×õÔÕ\ZzA„û\"Í—À¢V3Jb\rhYuX&İw¾³zzæ³7ÖR™hÆ>ÅÚÊ‘Oac9V|ò,#,á83zc0–Ç˜öøÕç9gş(qJa•˜1¬BkFîŒfğæ6\0¸†\ršFİV„-d^İMt¶í±ê‘Ô¹AìZB<è>½)Â²·KsbC:Î–µ®JN®‰£¾ÓIR\"Eî’¹¯éË7%÷TPÃâ+Ê‘ZñÜGŒ­‘ôŠÈ\níN³†¶G€oô³.m§d#OSj²-éG­zDêïi!ªøÚy±`6ËÛåÌÙİÏ+q9ºa•İÜGa´ñdÑa±«%‚ÌÁ\Z ƒ´‹š¤R^”èvKœ÷R,•¥(ly0Ò{­\r®OŠYÖ1Œ~˜Æ?ËŠœ«ÏöœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœR¼qJ®ıµéI [³•Î—î¶À^\'ŠûE»Ašşâl^P2n¨¬˜vR9\rB~şDeQÊK\0°úyñÇ#K‹O[Î\ZÒK¬©Ø%Z’ôGËøêÑÜvş!Ô­>ëÕy,é½\ZûíÍĞÎ®ÌÂ…1H	¦÷I™›gke-Å–\"²×—uå¦pN—%ø‚€œÌ„®ùÈÆ/ŒÍK)]ğmû=oWcf$¤!iÃ±Š®ïmÊ’SkY3\"é^ÿ\0´Â£Áª][\\ĞÃšïœı\'·²=_/zz‹	¥S-m’´<=¦)#ó‚rğ‘(ş¨Y$}Aˆ’ªöÄz ÎI+8¥ŸöËn#šÑê‡@XûµEƒæ$å©¼èPq\\)W>¿\0ÅeÙg¾“¡q]u>õ¨n ï]BpÊ5î½Ôs?Ã=°,Uå¦ìÖómÆ*×Zçb`ó7hö|™•ªDà%bMÂÇªØ^\r(¤cŒK‚Œ…˜‰–)i	htHßgóåSñ\\Û‚ÌÄ]™#ÌîËºV™ŒYrŞJ‘µ“,Èp€H\nhŸvÕÇY«¦ölV«¯­.½DD©3Í©bHõy=}ùŒa2P‘…<=ådÎF\0³œ3&µAe©PY‡€&r) ÉoC4´ˆRAOı•fÃ¸\nœ$ÂÇqXR/©Rb+ˆúÊ·<×›³®j=Rµ€¯¶›Ü\r}¨,Ùz—ø}úˆ°\\.\r\nc©Ó	`¨µºà\0s)!ïĞ5û \0*T™GV0IÆä¬ä9ƒÂğø,Cm²:éB4ïıÕU‰q%œÓˆƒŠã¸Ş#nê9ÿ\0Iâ!)=ylÈ^O‰ãğ©—gzåİ@%¶‹éuJêähF\0¤r}¼Ø„O\n\ZˆùÈ„:Ú¤ÁFxç9È¼KÀEáÈ³T%Åjß§¸ï_‰eÖ„B…ŠÉî÷”ûqğÖRunPÚÉvÿ\0²S¿][Z¹BztufÙµáéõ=\"‘€ı¦Š£éÉ	:ª1o~ø7È³|qd=½¹şXíŒ‹÷äÅ8U\'Ät©¦\"À†Ê‡é´ªdâ«ƒpëà4ÀÛ£H;ô;Ú¦©taéë¨Î…Láôs}›qeP\\o­‚ZmÕp¹»ƒË!wÄ¦iƒÀ„ÿ\0»8À›!ì|ø‡8€¸£VÅÆrT•=)÷æ¼´¥%rœ.€”tJÙ¦Ò<V¡Ûş|‚ª«ÏöœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœRœùãJsí)Å)Å+Ç¥yâ”â”â”â”â”â”â”â”â”â”â”â”â”â•ÿÙ');
/*!40000 ALTER TABLE `foto_conteudo_prefeitura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto_ocorrencia`
--

DROP TABLE IF EXISTS `foto_ocorrencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foto_ocorrencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dat_seguranca` datetime DEFAULT NULL,
  `tamanho` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `usu_seguranca` varchar(255) DEFAULT NULL,
  `versao` int(11) DEFAULT NULL,
  `binary_content` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_kt5sdkv50f6u46pe2iekgm11b` (`binary_content`),
  CONSTRAINT `FK_kt5sdkv50f6u46pe2iekgm11b` FOREIGN KEY (`binary_content`) REFERENCES `foto_conteudo_ocorrencia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto_ocorrencia`
--

LOCK TABLES `foto_ocorrencia` WRITE;
/*!40000 ALTER TABLE `foto_ocorrencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `foto_ocorrencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto_ocorrencia_aud`
--

DROP TABLE IF EXISTS `foto_ocorrencia_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foto_ocorrencia_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_7kkjsmt7jr4pll6fl1vkwfypp` (`rev`),
  CONSTRAINT `FK_7kkjsmt7jr4pll6fl1vkwfypp` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto_ocorrencia_aud`
--

LOCK TABLES `foto_ocorrencia_aud` WRITE;
/*!40000 ALTER TABLE `foto_ocorrencia_aud` DISABLE KEYS */;
INSERT INTO `foto_ocorrencia_aud` VALUES (7,135,0),(7,242,2);
/*!40000 ALTER TABLE `foto_ocorrencia_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto_prefeitura`
--

DROP TABLE IF EXISTS `foto_prefeitura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foto_prefeitura` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dat_seguranca` datetime DEFAULT NULL,
  `tamanho` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `usu_seguranca` varchar(255) DEFAULT NULL,
  `versao` int(11) DEFAULT NULL,
  `binary_content` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2x5f2yiybfimuly63mpx60udm` (`binary_content`),
  CONSTRAINT `FK_2x5f2yiybfimuly63mpx60udm` FOREIGN KEY (`binary_content`) REFERENCES `foto_conteudo_prefeitura` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto_prefeitura`
--

LOCK TABLES `foto_prefeitura` WRITE;
/*!40000 ALTER TABLE `foto_prefeitura` DISABLE KEYS */;
INSERT INTO `foto_prefeitura` VALUES (6,'2017-08-02 12:30:14',61284,'braso_prefeitura_250x250.jpg','image/jpeg','admin',1,6);
/*!40000 ALTER TABLE `foto_prefeitura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto_prefeitura_aud`
--

DROP TABLE IF EXISTS `foto_prefeitura_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foto_prefeitura_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_my9728nb91hke1h7lucntk3po` (`rev`),
  CONSTRAINT `FK_my9728nb91hke1h7lucntk3po` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto_prefeitura_aud`
--

LOCK TABLES `foto_prefeitura_aud` WRITE;
/*!40000 ALTER TABLE `foto_prefeitura_aud` DISABLE KEYS */;
INSERT INTO `foto_prefeitura_aud` VALUES (6,172,0);
/*!40000 ALTER TABLE `foto_prefeitura_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_ocorrencia`
--

DROP TABLE IF EXISTS `historico_ocorrencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historico_ocorrencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `data_historico` datetime NOT NULL,
  `observacao` longtext NOT NULL,
  `responsavel` varchar(100) NOT NULL,
  `ocorrencia` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_HISTORICOOCORRENCIA_OCORRENCIA` (`ocorrencia`),
  CONSTRAINT `FK_HISTORICOOCORRENCIA_OCORRENCIA` FOREIGN KEY (`ocorrencia`) REFERENCES `ocorrencia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_ocorrencia`
--

LOCK TABLES `historico_ocorrencia` WRITE;
/*!40000 ALTER TABLE `historico_ocorrencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_ocorrencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_ocorrencia_aud`
--

DROP TABLE IF EXISTS `historico_ocorrencia_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historico_ocorrencia_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `data_historico` datetime DEFAULT NULL,
  `observacao` longtext,
  `responsavel` varchar(100) DEFAULT NULL,
  `ocorrencia` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_f6x5hnh5ldnfcbapvv9sfhgnv` (`rev`),
  CONSTRAINT `FK_f6x5hnh5ldnfcbapvv9sfhgnv` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_ocorrencia_aud`
--

LOCK TABLES `historico_ocorrencia_aud` WRITE;
/*!40000 ALTER TABLE `historico_ocorrencia_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_ocorrencia_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logradouro`
--

DROP TABLE IF EXISTS `logradouro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logradouro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `nome` varchar(120) NOT NULL,
  `observacao` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logradouro`
--

LOCK TABLES `logradouro` WRITE;
/*!40000 ALTER TABLE `logradouro` DISABLE KEYS */;
/*!40000 ALTER TABLE `logradouro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logradouro_aud`
--

DROP TABLE IF EXISTS `logradouro_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logradouro_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `nome` varchar(120) DEFAULT NULL,
  `observacao` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_cidawl60dtbdd51sd6o44n6uj` (`rev`),
  CONSTRAINT `FK_cidawl60dtbdd51sd6o44n6uj` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logradouro_aud`
--

LOCK TABLES `logradouro_aud` WRITE;
/*!40000 ALTER TABLE `logradouro_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `logradouro_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocorrencia`
--

DROP TABLE IF EXISTS `ocorrencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocorrencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `data_conclusao` datetime DEFAULT NULL,
  `data_ocorrencia` datetime NOT NULL,
  `latitude` varchar(30) NOT NULL,
  `longitude` varchar(30) NOT NULL,
  `responsavel_conclusao` varchar(120) DEFAULT NULL,
  `status_ocorrencia` varchar(3) NOT NULL,
  `foto_ocorrencia` bigint(20) DEFAULT NULL,
  `pessoa` bigint(20) NOT NULL,
  `tipo_ocorrencia` bigint(20) NOT NULL,
  `observacao` longtext,
  `protocolo` varchar(100) DEFAULT NULL,
  `endereco` longtext,
  `observacao_conclusao` longtext,
  PRIMARY KEY (`id`),
  KEY `FK_OCORRENCIA_FOTO_OCORRENCIA` (`foto_ocorrencia`),
  KEY `FK_OCORRENCIA_PESSOA` (`pessoa`),
  KEY `FK_OCORRENCIA_TIPOOCORRENCIA` (`tipo_ocorrencia`),
  CONSTRAINT `FK_OCORRENCIA_FOTO_OCORRENCIA` FOREIGN KEY (`foto_ocorrencia`) REFERENCES `foto_ocorrencia` (`id`),
  CONSTRAINT `FK_OCORRENCIA_PESSOA` FOREIGN KEY (`pessoa`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `FK_OCORRENCIA_TIPOOCORRENCIA` FOREIGN KEY (`tipo_ocorrencia`) REFERENCES `tipo_ocorrencia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocorrencia`
--

LOCK TABLES `ocorrencia` WRITE;
/*!40000 ALTER TABLE `ocorrencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocorrencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocorrencia_aud`
--

DROP TABLE IF EXISTS `ocorrencia_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocorrencia_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `data_conclusao` datetime DEFAULT NULL,
  `data_ocorrencia` datetime DEFAULT NULL,
  `latitude` varchar(30) DEFAULT NULL,
  `longitude` varchar(30) DEFAULT NULL,
  `responsavel_conclusao` varchar(120) DEFAULT NULL,
  `status_ocorrencia` varchar(3) DEFAULT NULL,
  `foto_ocorrencia` bigint(20) DEFAULT NULL,
  `pessoa` bigint(20) DEFAULT NULL,
  `tipo_ocorrencia` bigint(20) DEFAULT NULL,
  `observacao` longtext,
  `protocolo` varchar(100) DEFAULT NULL,
  `endereco` longtext,
  `observacao_conclusao` longtext,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_os26hrhkks85vd0yr1wjdv6nw` (`rev`),
  CONSTRAINT `FK_os26hrhkks85vd0yr1wjdv6nw` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocorrencia_aud`
--

LOCK TABLES `ocorrencia_aud` WRITE;
/*!40000 ALTER TABLE `ocorrencia_aud` DISABLE KEYS */;
INSERT INTO `ocorrencia_aud` VALUES (14,135,0,NULL,'2017-06-14 19:33:46','-20.4613394','-45.427763',NULL,'ABE',7,14,13,'Tem um burraco muito grande aqui','010DA6F8212052521CBE380D9D08B3FF','R. Quintino BocaiÃºva, 288, Formiga - MG, 35570-000, Brazil',NULL),(14,242,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,136,0,NULL,'2017-06-14 19:37:47','','',NULL,'ABE',NULL,14,13,'Teste','F7782D109F0CCE8976FAAA9E87422757','Err',NULL);
/*!40000 ALTER TABLE `ocorrencia_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametros_aplicacao`
--

DROP TABLE IF EXISTS `parametros_aplicacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametros_aplicacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `host_smtp` varchar(100) DEFAULT NULL,
  `porta_smtp` varchar(100) DEFAULT NULL,
  `senha_email` varchar(100) DEFAULT NULL,
  `modelo_mensagem_cidadao` longtext,
  `modelo_mensagem_responsavel` longtext,
  `modelo_documento_ocorrencia` longtext,
  `cabecalho_documento_ocorrencia` longtext,
  `rodape_documento_ocorrencia` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametros_aplicacao`
--

LOCK TABLES `parametros_aplicacao` WRITE;
/*!40000 ALTER TABLE `parametros_aplicacao` DISABLE KEYS */;
INSERT INTO `parametros_aplicacao` VALUES (1,'2017-06-14 18:54:19','admin',14,'prefeituraformiga@gmail.com','smtp.gmail.com','587','pfereituraformiga','<p>Prezado Sr.(a) #NOME_CIDADAO#,</p>\n\n<p>A Prefeitura Municipal vem informar que a ocorr&ecirc;ncia de protocolo n&ordm; #PROTOCOLO_OCORRENCIA#, foi encaminhada ao setor respons&aacute;vel.</p>\n\n<p>Abaixo a descri&ccedil;&atilde;o dos dados da ocorr&ecirc;ncia:</p>\n\n<ul>\n	<li>Tipo: #TIPO_OCORRENCIA#</li>\n	<li>Data: #DATA_OCORRENCIA#</li>\n	<li>Endere&ccedil;o: #ENDERECO_OCORRENCIA#</li>\n	<li>Status: #STATUS_OCORRENCIA#</li>\n</ul>\n\n<p>Atenciosamente,</p>\n\n<p>Prefeitura Municipal</p>\n','<p>Prezado Sr.(a) Secret&aacute;rio,</p>\n\n<p>Informamos que a ocorr&ecirc;ncia de protocolo n&ordm; #PROTOCOLO_OCORRENCIA#, foi encaminhada para resolu&ccedil;&atilde;o.</p>\n\n<p>Abaixo a descri&ccedil;&atilde;o dos dados da ocorr&ecirc;ncia:</p>\n\n<ul>\n	<li>Tipo: #TIPO_OCORRENCIA#</li>\n	<li>Data: #DATA_OCORRENCIA#</li>\n	<li>Endere&ccedil;o: #ENDERECO_OCORRENCIA#</li>\n	<li>Status: #STATUS_OCORRENCIA#</li>\n	<li>Observa&ccedil;&atilde;o do Cidad&atilde;o: #OBSERVACAO_CIDADAO#</li>\n</ul>\n\n<p>Observa&ccedil;&atilde;o do Gabinete: #OBSERVACAO_RESPONSAVEL#</p>\n\n<p>Atenciosamente,</p>\n\n<p>Prefeitura Municipal</p>\n','<p><span style=\"font-size:12px\"><strong>Ocorr&ecirc;ncia Protocolo n&ordm;:&nbsp;</strong>#PROTOCOLO_OCORRENCIA#</span></p>\n\n<p><span style=\"font-size:12px\"><strong>Tipo:&nbsp;</strong>#TIPO_OCORRENCIA#</span></p>\n\n<p><span style=\"font-size:12px\"><strong>Solicitante:&nbsp;</strong>#NOME_CIDADAO#</span></p>\n\n<p><span style=\"font-size:12px\"><strong>Endere&ccedil;o:&nbsp;</strong>#ENDERECO_OCORRENCIA#</span></p>\n\n<p><span style=\"font-size:12px\"><strong>Data:&nbsp;</strong>#DATA_OCORRENCIA#</span></p>\n\n<p><span style=\"font-size:12px\"><strong>Status:&nbsp;</strong>#STATUS_OCORRENCIA#</span></p>\n\n<p><span style=\"font-size:12px\"><strong>Observa&ccedil;&atilde;o:&nbsp;</strong>#OBSERVACAO_CIDADAO#</span></p>\n\n<p><span style=\"font-size:12px\"><strong>Foto:</strong>&nbsp;</span></p>\n\n<p><span style=\"font-size:12px\">#FOTO_OCORRENCIA#</span></p>\n\n<hr />\n<p><span style=\"font-size:12px\"><strong>Data Conclus&atilde;o: </strong>#DATA_CONCLUSAO#</span></p>\n\n<p><span style=\"font-size:12px\"><strong>Respons&aacute;vel Conclus&atilde;o: </strong>#RESPONSAVEL_CONCLUSAO#</span></p>\n\n<p><span style=\"font-size:12px\"><strong>Observa&ccedil;&atilde;o:&nbsp;</strong>#OBSERVACAO_RESPONSAVEL#</span></p>\n\n<p>&nbsp;</p>\n\n<hr />\n<p><span style=\"font-size:10px\">DADOS DA ENTREGA/ENVIO DA OCORR&Ecirc;NCIA&nbsp;PROTOCOLO N&ordm;: &nbsp;#PROTOCOLO_OCORRENCIA#</span><br />\n<span style=\"font-size:10px\">RECEBIDO EM:_____/______/_________ &agrave;s ___________Horas.</span><br />\n<span style=\"font-size:10px\">Notificado:_________________________________________________________&nbsp;</span><em>(representante respons&aacute;vel/ procurador)</em><br />\n<span style=\"font-size:10px\">RG:_____________________________CPF:_____________________________</span></p>\n','<table align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:500px\">\n	<tbody>\n		<tr>\n			<td style=\"text-align:center\">#BRASAO_PREFEITURA#</td>\n			<td>\n			<p style=\"text-align:center\"><strong>Prefeitura Municipal</strong></p>\n\n			<p style=\"text-align:center\"><strong>GABINETE DO PREFEITO</strong></p>\n			</td>\n		</tr>\n	</tbody>\n</table>\n','<p>&nbsp;</p>\n\n<hr />\n<p style=\"text-align:center\"><span style=\"font-size:12px\"><strong><em>Rua Quintino Bocaiuva, 298&nbsp;- Centro - Formiga/ Minas Gerais - 35.570-000<br />\nrafael.souza@proex.net.br - (37) 9.9801-4265</em></strong></span></p>\n');
/*!40000 ALTER TABLE `parametros_aplicacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `celular` varchar(20) DEFAULT NULL,
  `data_nascimento` datetime DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `nome` varchar(120) NOT NULL,
  `senha` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (13,'2017-08-02 11:24:24','admin',1,'37999668493',NULL,'thiagoleaopinheiro@gmail.com','Thiago LeÃ£o Pinheiro','B072F5E846E2FF738628D448071579C9'),(14,'2017-06-14 18:49:42','admin',0,NULL,NULL,'rafael.souza@proex.net.br','Rafael Augusto Reis de Souza','E1F29E9122E6D752EE91E993DC2602C9'),(15,'2017-08-02 11:25:16','admin',0,'37999439083',NULL,'pmformiga.secretariadegoverno@gmail.com','EugÃªnio Vilela','9501B561A0A32ADF14D44ED28B98D406'),(16,'2017-08-02 11:26:09','admin',0,'37998358509',NULL,'rejane.froex@outlook.com','Rejane FrÃ³es','9501B561A0A32ADF14D44ED28B98D406'),(17,'2017-08-02 11:26:53','admin',0,'37984023597',NULL,'brunafelixpsl@gmail.com','Bruna Felix','9501B561A0A32ADF14D44ED28B98D406'),(18,'2017-08-02 11:27:36','admin',0,'37999842527',NULL,'deniodutra@gmail.com','Denio Dutra Barbosa','9501B561A0A32ADF14D44ED28B98D406'),(19,'2017-08-02 11:28:12','admin',0,'37999542983',NULL,NULL,'AdÃ£o - Motorista do Prefeito','9501B561A0A32ADF14D44ED28B98D406'),(20,'2017-08-02 11:28:51','admin',0,'37999253760',NULL,'comunicacao@gmail.com','Welerson de Andrade Cunha','5BE41631594AF97C2DDA16879780B5EC'),(21,'2017-08-02 11:29:26','admin',0,'37998625304',NULL,'aluisioveloso@gmail.com','AluÃ­sio Veloso da Cunha','9501B561A0A32ADF14D44ED28B98D406'),(22,'2017-08-02 11:30:24','admin',0,'37999633683',NULL,'sandrasalviano@bol.com.br;procuradoriafga@gmail.com','Sandra Micheline de Castro Salviano','2BE34FCCAB29B6A6F511FA3E5B8F10C1'),(23,'2017-08-02 11:31:16','admin',0,'37998011165',NULL,'procuradoriafga@gmail.com;oliveiraneto.adv@gmail.com','JosÃ© Ferreira de Oliveira Neto','2BE34FCCAB29B6A6F511FA3E5B8F10C1'),(24,'2017-08-02 11:32:11','admin',0,'37999629283',NULL,'arnaldo@gmail.com','Arnaldo Gontijo de Freitas','B6ECC48268C8F879A2873E967ECC4AD3'),(25,'2017-08-02 11:32:56','admin',0,'37984123469',NULL,'jronaldocouto@hotmail.com','JosÃ© Ronaldo Couto','9501B561A0A32ADF14D44ED28B98D406'),(26,'2017-08-02 11:33:39','admin',0,'37984187807',NULL,'semplarformiga@gmail.com','Romulo Cabral de Oliveira','9501B561A0A32ADF14D44ED28B98D406'),(27,'2017-08-02 11:34:20','admin',0,'37984141388',NULL,'giovanaengambiental@gmail.com','Giovana Mara Rodrigues Borges Rocha','9501B561A0A32ADF14D44ED28B98D406'),(28,'2017-08-02 11:34:57','admin',0,'37984029546',NULL,'jose@gmail.com','JosÃ© Thiers de Freitas','F8335C72B21C9CF06B5B2601671314C2'),(29,'2017-08-02 11:35:44','admin',0,'37999555783',NULL,'matheusfaria.assessoria@gmail.com','Matheus Afonso de Faria','9501B561A0A32ADF14D44ED28B98D406'),(30,'2017-08-02 11:36:35','admin',0,'37984089638',NULL,'jadersonteixeirasmdh@hotmail.com','Jaderson Teixeira ','9501B561A0A32ADF14D44ED28B98D406'),(31,'2017-08-02 11:37:23','admin',0,'37999521783',NULL,'milenaribeiroadv@gmail.com;sec.adm.pmf@gmail.com','Milena Ribeiro da Silva','9501B561A0A32ADF14D44ED28B98D406'),(32,'2017-08-02 11:38:13','admin',0,'37984011338',NULL,'licitcompras@yahoo.com.br','Stefany Moura de NÃ³brega','9501B561A0A32ADF14D44ED28B98D406'),(33,'2017-08-02 11:38:55','admin',0,'37999471983',NULL,'smdeformiga@gmail.com','Alisson Ricardo de SÃ¡','9501B561A0A32ADF14D44ED28B98D406'),(34,'2017-08-02 11:39:26','admin',0,'37984015180',NULL,'glorilza@gmail.com','Glorilza Miranda','9501B561A0A32ADF14D44ED28B98D406'),(35,'2017-08-02 11:40:15','admin',0,'37999678393',NULL,'geraldopereirasaude.gov@gmail.com','JosÃ© Geraldo Pereira','9501B561A0A32ADF14D44ED28B98D406'),(36,'2017-08-02 11:40:52','admin',0,'37984182913',NULL,'mota.denise@yahoo.com.br','Denise de Meneses Mota','9501B561A0A32ADF14D44ED28B98D406'),(37,'2017-08-02 11:41:33','admin',0,'37984019042',NULL,'seceducacaoformiga@gmail.com;cidcorrea@bol.com.br','Cid CorrÃªa Mesquita','9501B561A0A32ADF14D44ED28B98D406'),(38,'2017-08-02 11:42:13','admin',0,'37984187431',NULL,'alexartigo28@hotmail.com','Alex Sandro Alvarenga Arouca','9501B561A0A32ADF14D44ED28B98D406'),(39,'2017-08-02 11:42:48','admin',0,'37984024089',NULL,'contabilidadefga@yahoo.com.br','Cleuton Alves','9501B561A0A32ADF14D44ED28B98D406'),(40,'2017-08-02 11:43:25','admin',0,'37984187909',NULL,'controladoriafga@yahoo.com.br','Francisco Ferreira Neto','9501B561A0A32ADF14D44ED28B98D406'),(41,'2017-08-02 11:44:09','admin',0,'37999075791',NULL,'josepereira@gmail.com','JosÃ© Pereira de Sousa','9501B561A0A32ADF14D44ED28B98D406'),(42,'2017-08-02 11:44:48','admin',0,'37999566251',NULL,'baldomirogsantos@gmail.com','Baldomiro JosÃ© dos Santos','9501B561A0A32ADF14D44ED28B98D406'),(43,'2017-08-02 11:45:20','admin',0,NULL,NULL,'ronaldo@gmail.com','Rodaldo CÃ¢ndido da Silva','9501B561A0A32ADF14D44ED28B98D406'),(44,'2017-08-02 11:51:55','admin',0,NULL,NULL,'previfor@formiga.mg.gov.br','Everaldo Alves Pacheco','5BE41631594AF97C2DDA16879780B5EC'),(45,'2017-08-02 12:27:14','admin',0,NULL,NULL,'secretariaobrasfga@yahoo.com.br','FlÃ¡vio Passos','2CB1601E8F90926457D18F6B3BAC4712');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa_aud`
--

DROP TABLE IF EXISTS `pessoa_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `celular` varchar(20) DEFAULT NULL,
  `data_nascimento` datetime DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `nome` varchar(120) DEFAULT NULL,
  `senha` longtext,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_gnafx1i89dr71c5arre5ai4im` (`rev`),
  CONSTRAINT `FK_gnafx1i89dr71c5arre5ai4im` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa_aud`
--

LOCK TABLES `pessoa_aud` WRITE;
/*!40000 ALTER TABLE `pessoa_aud` DISABLE KEYS */;
INSERT INTO `pessoa_aud` VALUES (13,127,0,NULL,NULL,'thiagoleaopinheiro@gmail.com','Thiago LeÃ£o Pinheiro','B072F5E846E2FF738628D448071579C9'),(13,138,1,'37999668493',NULL,'thiagoleaopinheiro@gmail.com','Thiago LeÃ£o Pinheiro','B072F5E846E2FF738628D448071579C9'),(14,128,0,NULL,NULL,'rafael.souza@proex.net.br','Rafael Augusto Reis de Souza','E1F29E9122E6D752EE91E993DC2602C9'),(15,139,0,'37999439083',NULL,'pmformiga.secretariadegoverno@gmail.com','EugÃªnio Vilela','9501B561A0A32ADF14D44ED28B98D406'),(16,140,0,'37998358509',NULL,'rejane.froex@outlook.com','Rejane FrÃ³es','9501B561A0A32ADF14D44ED28B98D406'),(17,141,0,'37984023597',NULL,'brunafelixpsl@gmail.com','Bruna Felix','9501B561A0A32ADF14D44ED28B98D406'),(18,142,0,'37999842527',NULL,'deniodutra@gmail.com','Denio Dutra Barbosa','9501B561A0A32ADF14D44ED28B98D406'),(19,143,0,'37999542983',NULL,NULL,'AdÃ£o - Motorista do Prefeito','9501B561A0A32ADF14D44ED28B98D406'),(20,144,0,'37999253760',NULL,'comunicacao@gmail.com','Welerson de Andrade Cunha','5BE41631594AF97C2DDA16879780B5EC'),(21,145,0,'37998625304',NULL,'aluisioveloso@gmail.com','AluÃ­sio Veloso da Cunha','9501B561A0A32ADF14D44ED28B98D406'),(22,146,0,'37999633683',NULL,'sandrasalviano@bol.com.br;procuradoriafga@gmail.com','Sandra Micheline de Castro Salviano','2BE34FCCAB29B6A6F511FA3E5B8F10C1'),(23,147,0,'37998011165',NULL,'procuradoriafga@gmail.com;oliveiraneto.adv@gmail.com','JosÃ© Ferreira de Oliveira Neto','2BE34FCCAB29B6A6F511FA3E5B8F10C1'),(24,148,0,'37999629283',NULL,'arnaldo@gmail.com','Arnaldo Gontijo de Freitas','B6ECC48268C8F879A2873E967ECC4AD3'),(25,149,0,'37984123469',NULL,'jronaldocouto@hotmail.com','JosÃ© Ronaldo Couto','9501B561A0A32ADF14D44ED28B98D406'),(26,150,0,'37984187807',NULL,'semplarformiga@gmail.com','Romulo Cabral de Oliveira','9501B561A0A32ADF14D44ED28B98D406'),(27,151,0,'37984141388',NULL,'giovanaengambiental@gmail.com','Giovana Mara Rodrigues Borges Rocha','9501B561A0A32ADF14D44ED28B98D406'),(28,152,0,'37984029546',NULL,'jose@gmail.com','JosÃ© Thiers de Freitas','F8335C72B21C9CF06B5B2601671314C2'),(29,153,0,'37999555783',NULL,'matheusfaria.assessoria@gmail.com','Matheus Afonso de Faria','9501B561A0A32ADF14D44ED28B98D406'),(30,154,0,'37984089638',NULL,'jadersonteixeirasmdh@hotmail.com','Jaderson Teixeira ','9501B561A0A32ADF14D44ED28B98D406'),(31,155,0,'37999521783',NULL,'milenaribeiroadv@gmail.com;sec.adm.pmf@gmail.com','Milena Ribeiro da Silva','9501B561A0A32ADF14D44ED28B98D406'),(32,156,0,'37984011338',NULL,'licitcompras@yahoo.com.br','Stefany Moura de NÃ³brega','9501B561A0A32ADF14D44ED28B98D406'),(33,157,0,'37999471983',NULL,'smdeformiga@gmail.com','Alisson Ricardo de SÃ¡','9501B561A0A32ADF14D44ED28B98D406'),(34,158,0,'37984015180',NULL,'glorilza@gmail.com','Glorilza Miranda','9501B561A0A32ADF14D44ED28B98D406'),(35,159,0,'37999678393',NULL,'geraldopereirasaude.gov@gmail.com','JosÃ© Geraldo Pereira','9501B561A0A32ADF14D44ED28B98D406'),(36,160,0,'37984182913',NULL,'mota.denise@yahoo.com.br','Denise de Meneses Mota','9501B561A0A32ADF14D44ED28B98D406'),(37,161,0,'37984019042',NULL,'seceducacaoformiga@gmail.com;cidcorrea@bol.com.br','Cid CorrÃªa Mesquita','9501B561A0A32ADF14D44ED28B98D406'),(38,162,0,'37984187431',NULL,'alexartigo28@hotmail.com','Alex Sandro Alvarenga Arouca','9501B561A0A32ADF14D44ED28B98D406'),(39,163,0,'37984024089',NULL,'contabilidadefga@yahoo.com.br','Cleuton Alves','9501B561A0A32ADF14D44ED28B98D406'),(40,164,0,'37984187909',NULL,'controladoriafga@yahoo.com.br','Francisco Ferreira Neto','9501B561A0A32ADF14D44ED28B98D406'),(41,165,0,'37999075791',NULL,'josepereira@gmail.com','JosÃ© Pereira de Sousa','9501B561A0A32ADF14D44ED28B98D406'),(42,166,0,'37999566251',NULL,'baldomirogsantos@gmail.com','Baldomiro JosÃ© dos Santos','9501B561A0A32ADF14D44ED28B98D406'),(43,167,0,NULL,NULL,'ronaldo@gmail.com','Rodaldo CÃ¢ndido da Silva','9501B561A0A32ADF14D44ED28B98D406'),(44,168,0,NULL,NULL,'previfor@formiga.mg.gov.br','Everaldo Alves Pacheco','5BE41631594AF97C2DDA16879780B5EC'),(45,170,0,NULL,NULL,'secretariaobrasfga@yahoo.com.br','FlÃ¡vio Passos','2CB1601E8F90926457D18F6B3BAC4712');
/*!40000 ALTER TABLE `pessoa_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prefeitura`
--

DROP TABLE IF EXISTS `prefeitura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prefeitura` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `cnpj` varchar(14) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `cidade` varchar(120) DEFAULT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `fax` varchar(10) DEFAULT NULL,
  `nome` varchar(200) NOT NULL,
  `nome_abreviado` varchar(100) DEFAULT NULL,
  `site` varchar(200) DEFAULT NULL,
  `telefone` varchar(10) DEFAULT NULL,
  `bairro` bigint(20) DEFAULT NULL,
  `logradouro` bigint(20) DEFAULT NULL,
  `brasao` bigint(20) DEFAULT NULL,
  `logomarca` bigint(20) DEFAULT NULL,
  `latitude` varchar(20) DEFAULT NULL,
  `longitude` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CAD_PREFEITURA_BRASAO` (`brasao`),
  KEY `FK_CAD_PREFEITURA_FOTO_PREFEITURA` (`logomarca`),
  KEY `FK_ENDERECO_BAIRRO` (`bairro`),
  KEY `FK_ENDERECO_LOGRADOURO` (`logradouro`),
  CONSTRAINT `FK_CAD_PREFEITURA_BRASAO` FOREIGN KEY (`brasao`) REFERENCES `foto_prefeitura` (`id`),
  CONSTRAINT `FK_CAD_PREFEITURA_FOTO_PREFEITURA` FOREIGN KEY (`logomarca`) REFERENCES `foto_prefeitura` (`id`),
  CONSTRAINT `FK_ENDERECO_BAIRRO` FOREIGN KEY (`bairro`) REFERENCES `bairro` (`id`),
  CONSTRAINT `FK_ENDERECO_LOGRADOURO` FOREIGN KEY (`logradouro`) REFERENCES `logradouro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prefeitura`
--

LOCK TABLES `prefeitura` WRITE;
/*!40000 ALTER TABLE `prefeitura` DISABLE KEYS */;
INSERT INTO `prefeitura` VALUES (1,'2017-08-02 12:30:14','admin',17,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Prefeitura Municipal de Formiga','Prefeitura de Formiga',NULL,NULL,NULL,NULL,6,NULL,'-20.463145','-45.430257');
/*!40000 ALTER TABLE `prefeitura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prefeitura_aud`
--

DROP TABLE IF EXISTS `prefeitura_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prefeitura_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `cnpj` varchar(14) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `cidade` varchar(120) DEFAULT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `fax` varchar(10) DEFAULT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `nome_abreviado` varchar(100) DEFAULT NULL,
  `site` varchar(200) DEFAULT NULL,
  `telefone` varchar(10) DEFAULT NULL,
  `bairro` bigint(20) DEFAULT NULL,
  `logradouro` bigint(20) DEFAULT NULL,
  `brasao` bigint(20) DEFAULT NULL,
  `logomarca` bigint(20) DEFAULT NULL,
  `latitude` varchar(20) DEFAULT NULL,
  `longitude` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_n1bklkwjt8x4klshlg23udxlg` (`rev`),
  CONSTRAINT `FK_n1bklkwjt8x4klshlg23udxlg` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prefeitura_aud`
--

LOCK TABLES `prefeitura_aud` WRITE;
/*!40000 ALTER TABLE `prefeitura_aud` DISABLE KEYS */;
INSERT INTO `prefeitura_aud` VALUES (1,131,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Prefeitura Municipal de Formiga','Prefeitura de Formiga',NULL,NULL,NULL,NULL,NULL,NULL,'-20.463145','-45.430257'),(1,169,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Prefeitura Municipal de Formiga','Prefeitura de Formiga',NULL,NULL,NULL,NULL,NULL,NULL,'-20.463145','-45.430257'),(1,172,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Prefeitura Municipal de Formiga','Prefeitura de Formiga',NULL,NULL,NULL,NULL,6,NULL,'-20.463145','-45.430257');
/*!40000 ALTER TABLE `prefeitura_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revision`
--

DROP TABLE IF EXISTS `revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `revision` (
  `rev` int(11) NOT NULL AUTO_INCREMENT,
  `acao_realizada` varchar(4) DEFAULT NULL,
  `caso_de_uso` varchar(255) DEFAULT NULL,
  `data_ult_alteracao` datetime DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `usuario_ult_alteracao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rev`)
) ENGINE=InnoDB AUTO_INCREMENT=243 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revision`
--

LOCK TABLES `revision` WRITE;
/*!40000 ALTER TABLE `revision` DISABLE KEYS */;
INSERT INTO `revision` VALUES (127,NULL,NULL,'2017-06-14 18:49:13',NULL,'admin'),(128,NULL,NULL,'2017-06-14 18:49:42',NULL,'admin'),(129,NULL,NULL,'2017-06-14 18:50:21',NULL,'admin'),(130,NULL,NULL,'2017-06-14 18:50:44',NULL,'admin'),(131,NULL,NULL,'2017-06-14 18:53:00',NULL,'admin'),(132,NULL,NULL,'2017-06-14 19:29:21',NULL,'admin'),(133,NULL,NULL,'2017-06-14 19:30:01',NULL,'admin'),(134,NULL,NULL,'2017-06-14 19:30:12',NULL,'admin'),(135,NULL,NULL,'2017-06-14 19:33:47',NULL,NULL),(136,NULL,NULL,'2017-06-14 19:37:48',NULL,NULL),(137,NULL,NULL,'2017-06-16 14:06:37',NULL,'admin'),(138,NULL,NULL,'2017-08-02 11:24:24',NULL,'admin'),(139,NULL,NULL,'2017-08-02 11:25:16',NULL,'admin'),(140,NULL,NULL,'2017-08-02 11:26:09',NULL,'admin'),(141,NULL,NULL,'2017-08-02 11:26:53',NULL,'admin'),(142,NULL,NULL,'2017-08-02 11:27:36',NULL,'admin'),(143,NULL,NULL,'2017-08-02 11:28:12',NULL,'admin'),(144,NULL,NULL,'2017-08-02 11:28:51',NULL,'admin'),(145,NULL,NULL,'2017-08-02 11:29:26',NULL,'admin'),(146,NULL,NULL,'2017-08-02 11:30:24',NULL,'admin'),(147,NULL,NULL,'2017-08-02 11:31:16',NULL,'admin'),(148,NULL,NULL,'2017-08-02 11:32:11',NULL,'admin'),(149,NULL,NULL,'2017-08-02 11:32:56',NULL,'admin'),(150,NULL,NULL,'2017-08-02 11:33:39',NULL,'admin'),(151,NULL,NULL,'2017-08-02 11:34:20',NULL,'admin'),(152,NULL,NULL,'2017-08-02 11:34:57',NULL,'admin'),(153,NULL,NULL,'2017-08-02 11:35:44',NULL,'admin'),(154,NULL,NULL,'2017-08-02 11:36:35',NULL,'admin'),(155,NULL,NULL,'2017-08-02 11:37:23',NULL,'admin'),(156,NULL,NULL,'2017-08-02 11:38:13',NULL,'admin'),(157,NULL,NULL,'2017-08-02 11:38:55',NULL,'admin'),(158,NULL,NULL,'2017-08-02 11:39:26',NULL,'admin'),(159,NULL,NULL,'2017-08-02 11:40:15',NULL,'admin'),(160,NULL,NULL,'2017-08-02 11:40:52',NULL,'admin'),(161,NULL,NULL,'2017-08-02 11:41:33',NULL,'admin'),(162,NULL,NULL,'2017-08-02 11:42:13',NULL,'admin'),(163,NULL,NULL,'2017-08-02 11:42:48',NULL,'admin'),(164,NULL,NULL,'2017-08-02 11:43:25',NULL,'admin'),(165,NULL,NULL,'2017-08-02 11:44:09',NULL,'admin'),(166,NULL,NULL,'2017-08-02 11:44:48',NULL,'admin'),(167,NULL,NULL,'2017-08-02 11:45:20',NULL,'admin'),(168,NULL,NULL,'2017-08-02 11:51:55',NULL,'admin'),(169,NULL,NULL,'2017-08-02 11:52:53',NULL,'admin'),(170,NULL,NULL,'2017-08-02 12:27:14',NULL,'admin'),(171,NULL,NULL,'2017-08-02 12:27:52',NULL,'admin'),(172,NULL,NULL,'2017-08-02 12:30:14',NULL,'admin'),(173,NULL,NULL,'2017-08-02 12:57:37',NULL,'admin'),(174,NULL,NULL,'2017-08-02 12:57:56',NULL,'admin'),(175,NULL,NULL,'2017-08-02 12:58:46',NULL,'admin'),(176,NULL,NULL,'2017-08-02 12:59:03',NULL,'admin'),(177,NULL,NULL,'2017-08-02 12:59:15',NULL,'admin'),(178,NULL,NULL,'2017-08-02 12:59:22',NULL,'admin'),(179,NULL,NULL,'2017-08-02 12:59:33',NULL,'admin'),(180,NULL,NULL,'2017-08-02 12:59:42',NULL,'admin'),(181,NULL,NULL,'2017-08-02 12:59:54',NULL,'admin'),(182,NULL,NULL,'2017-08-02 13:00:10',NULL,'admin'),(183,NULL,NULL,'2017-08-02 13:00:25',NULL,'admin'),(184,NULL,NULL,'2017-08-02 13:00:32',NULL,'admin'),(185,NULL,NULL,'2017-08-02 13:00:43',NULL,'admin'),(186,NULL,NULL,'2017-08-02 13:00:59',NULL,'admin'),(187,NULL,NULL,'2017-08-02 13:01:14',NULL,'admin'),(188,NULL,NULL,'2017-08-02 13:01:32',NULL,'admin'),(189,NULL,NULL,'2017-08-02 13:01:43',NULL,'admin'),(190,NULL,NULL,'2017-08-02 13:01:56',NULL,'admin'),(191,NULL,NULL,'2017-08-02 13:02:06',NULL,'admin'),(192,NULL,NULL,'2017-08-02 13:02:22',NULL,'admin'),(193,NULL,NULL,'2017-08-02 13:02:37',NULL,'admin'),(194,NULL,NULL,'2017-08-02 13:02:47',NULL,'admin'),(195,NULL,NULL,'2017-08-02 13:02:56',NULL,'admin'),(196,NULL,NULL,'2017-08-02 13:03:07',NULL,'admin'),(197,NULL,NULL,'2017-08-02 13:03:33',NULL,'admin'),(198,NULL,NULL,'2017-08-02 13:03:58',NULL,'admin'),(199,NULL,NULL,'2017-08-02 13:04:07',NULL,'admin'),(200,NULL,NULL,'2017-08-02 13:04:17',NULL,'admin'),(201,NULL,NULL,'2017-08-02 13:04:36',NULL,'admin'),(202,NULL,NULL,'2017-08-02 13:05:01',NULL,'admin'),(203,NULL,NULL,'2017-08-02 13:05:10',NULL,'admin'),(204,NULL,NULL,'2017-08-02 13:05:26',NULL,'admin'),(205,NULL,NULL,'2017-08-02 13:05:39',NULL,'admin'),(206,NULL,NULL,'2017-08-02 13:05:55',NULL,'admin'),(207,NULL,NULL,'2017-08-02 13:06:06',NULL,'admin'),(208,NULL,NULL,'2017-08-02 13:06:17',NULL,'admin'),(209,NULL,NULL,'2017-08-02 13:06:45',NULL,'admin'),(210,NULL,NULL,'2017-08-02 13:06:56',NULL,'admin'),(211,NULL,NULL,'2017-08-02 13:07:12',NULL,'admin'),(212,NULL,NULL,'2017-08-02 13:07:26',NULL,'admin'),(213,NULL,NULL,'2017-08-02 13:07:41',NULL,'admin'),(214,NULL,NULL,'2017-08-02 13:07:51',NULL,'admin'),(215,NULL,NULL,'2017-08-02 13:08:01',NULL,'admin'),(216,NULL,NULL,'2017-08-02 13:08:11',NULL,'admin'),(217,NULL,NULL,'2017-08-02 13:08:25',NULL,'admin'),(218,NULL,NULL,'2017-08-02 13:08:40',NULL,'admin'),(219,NULL,NULL,'2017-08-02 13:09:11',NULL,'admin'),(220,NULL,NULL,'2017-08-02 13:09:24',NULL,'admin'),(221,NULL,NULL,'2017-08-02 13:09:35',NULL,'admin'),(222,NULL,NULL,'2017-08-02 13:09:49',NULL,'admin'),(223,NULL,NULL,'2017-08-02 13:10:00',NULL,'admin'),(224,NULL,NULL,'2017-08-02 13:10:24',NULL,'admin'),(225,NULL,NULL,'2017-08-02 13:10:36',NULL,'admin'),(226,NULL,NULL,'2017-08-02 13:10:51',NULL,'admin'),(227,NULL,NULL,'2017-08-02 13:11:04',NULL,'admin'),(228,NULL,NULL,'2017-08-02 13:11:22',NULL,'admin'),(229,NULL,NULL,'2017-08-02 13:11:30',NULL,'admin'),(230,NULL,NULL,'2017-08-02 13:12:02',NULL,'admin'),(231,NULL,NULL,'2017-08-02 13:12:26',NULL,'admin'),(232,NULL,NULL,'2017-08-02 13:13:06',NULL,'admin'),(233,NULL,NULL,'2017-08-02 13:13:23',NULL,'admin'),(234,NULL,NULL,'2017-08-02 13:13:36',NULL,'admin'),(235,NULL,NULL,'2017-08-02 13:13:55',NULL,'admin'),(236,NULL,NULL,'2017-08-02 13:14:07',NULL,'admin'),(237,NULL,NULL,'2017-08-02 13:14:17',NULL,'admin'),(238,NULL,NULL,'2017-08-02 13:14:29',NULL,'admin'),(239,NULL,NULL,'2017-08-02 13:14:43',NULL,'admin'),(240,NULL,NULL,'2017-08-02 13:14:56',NULL,'admin'),(241,NULL,NULL,'2017-08-02 13:15:12',NULL,'admin'),(242,NULL,NULL,'2017-08-17 12:51:59',NULL,'admin');
/*!40000 ALTER TABLE `revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretariado`
--

DROP TABLE IF EXISTS `secretariado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secretariado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `tipo` varchar(3) NOT NULL,
  `pessoa` bigint(20) NOT NULL,
  `prefeitura` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SECRETARIADO_PESSOA` (`pessoa`),
  KEY `FK_SECRETARIADO_PREFEITURA` (`prefeitura`),
  CONSTRAINT `FK_SECRETARIADO_PESSOA` FOREIGN KEY (`pessoa`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `FK_SECRETARIADO_PREFEITURA` FOREIGN KEY (`prefeitura`) REFERENCES `prefeitura` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretariado`
--

LOCK TABLES `secretariado` WRITE;
/*!40000 ALTER TABLE `secretariado` DISABLE KEYS */;
INSERT INTO `secretariado` VALUES (3,'2017-08-02 12:30:14','admin',4,'GAB',13,1),(4,'2017-08-02 12:30:14','admin',2,'PRE',15,1),(5,'2017-08-02 12:30:14','admin',2,'VIC',37,1),(6,'2017-08-02 12:30:14','admin',2,'FAZ',39,1),(7,'2017-08-02 12:30:14','admin',2,'EDU',37,1),(8,'2017-08-02 12:30:14','admin',2,'SOC',30,1),(9,'2017-08-02 12:30:14','admin',2,'CON',40,1),(10,'2017-08-02 12:30:14','admin',2,'PRO',22,1),(11,'2017-08-02 12:30:14','admin',2,'ADM',31,1),(12,'2017-08-02 12:30:14','admin',2,'DES',33,1),(13,'2017-08-02 12:30:14','admin',2,'OBR',45,1),(14,'2017-08-02 12:30:14','admin',2,'MEI',27,1),(15,'2017-08-02 12:30:14','admin',2,'SAU',35,1),(16,'2017-08-02 12:30:14','admin',2,'CUL',21,1),(17,'2017-08-02 12:30:14','admin',2,'PLA',26,1),(18,'2017-08-02 12:30:14','admin',2,'OUV',20,1),(19,'2017-08-02 12:30:14','admin',2,'PRF',41,1),(20,'2017-08-02 12:30:14','admin',2,'SAA',44,1);
/*!40000 ALTER TABLE `secretariado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretariado_aud`
--

DROP TABLE IF EXISTS `secretariado_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secretariado_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `tipo` varchar(3) DEFAULT NULL,
  `pessoa` bigint(20) DEFAULT NULL,
  `prefeitura` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_jfavjai6vq96rt9xbu5hnnysd` (`rev`),
  CONSTRAINT `FK_jfavjai6vq96rt9xbu5hnnysd` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretariado_aud`
--

LOCK TABLES `secretariado_aud` WRITE;
/*!40000 ALTER TABLE `secretariado_aud` DISABLE KEYS */;
INSERT INTO `secretariado_aud` VALUES (3,131,0,'ADM',13,1),(3,137,1,'OBR',13,1),(3,169,1,'ADM',13,1),(3,171,1,'GAB',13,1),(4,169,0,'PRE',15,1),(5,169,0,'VIC',37,1),(6,169,0,'PLA',39,1),(6,171,1,'FAZ',39,1),(7,169,0,'EDU',37,1),(8,169,0,'SOC',30,1),(9,169,0,'JUR',40,1),(9,171,1,'CON',40,1),(10,169,0,'PLA',22,1),(10,171,1,'PRO',22,1),(11,169,0,'ADM',31,1),(12,169,0,'DES',33,1),(13,169,0,'OBR',24,1),(13,171,1,'OBR',45,1),(14,169,0,'MEI',27,1),(15,169,0,'SAU',35,1),(16,169,0,'CUL',21,1),(17,169,0,'PLA',26,1),(18,169,0,'JUR',20,1),(18,171,1,'OUV',20,1),(19,169,0,'JUR',41,1),(19,171,1,'PRF',41,1),(20,169,0,'JUR',44,1),(20,171,1,'SAA',44,1);
/*!40000 ALTER TABLE `secretariado_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_menu`
--

DROP TABLE IF EXISTS `seg_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `url` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_menu`
--

LOCK TABLES `seg_menu` WRITE;
/*!40000 ALTER TABLE `seg_menu` DISABLE KEYS */;
INSERT INTO `seg_menu` VALUES (1,'2014-10-06 17:02:00','admin',4,'Cadastro de UsuÃ¡rios','segusuario'),(2,'2014-09-23 13:43:00','admin',1,'Cadastro de Menus','segmenu'),(3,'2014-10-23 09:16:07','admin',2,'Cadastro de Perfil','segperfil'),(4,'2014-09-23 13:00:00','amdmin',1,'Cadastro de Regras de Acesso','segperfilmenu'),(5,'2014-10-20 11:04:15','admin',0,'Trocar Senha','segtrocarsenha'),(6,'2014-10-21 08:42:32','admin',0,'Auditoria','segauditoria'),(7,'2016-11-17 13:34:17','admin',0,'Controle de Acesso','segcontroleacesso'),(8,'2017-06-09 10:04:59','admin',0,'Cadastro de OcorrÃªncias','ocorrencia'),(9,'2017-06-09 10:05:22','admin',0,'Tarefas do UsuÃ¡rio','minhastarefa'),(10,'2017-06-09 10:05:38','admin',0,'ParÃ¢metros da AplicaÃ§Ã£o','parametrosaplicacao'),(11,'2017-06-09 10:05:51','admin',0,'Cadastro de Pessoas','pessoa'),(12,'2017-06-09 10:06:07','admin',0,'Cadastro da Prefeitura','prefeitura'),(13,'2017-06-09 10:06:29','admin',0,'Cadastro de Tipos de OcorrÃªncia','tipoocorrencia'),(14,'2017-06-09 10:07:05','admin',0,'Mapa de OcorrÃªncias','mapaocorrencias');
/*!40000 ALTER TABLE `seg_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_menu_aud`
--

DROP TABLE IF EXISTS `seg_menu_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_menu_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `url` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_4a98h1uteo27dxv5mri49a6nd` (`rev`),
  CONSTRAINT `FK_4a98h1uteo27dxv5mri49a6nd` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_menu_aud`
--

LOCK TABLES `seg_menu_aud` WRITE;
/*!40000 ALTER TABLE `seg_menu_aud` DISABLE KEYS */;
INSERT INTO `seg_menu_aud` VALUES (8,108,0,'Cadastro de OcorrÃªncias','ocorrencia'),(9,109,0,'Tarefas do UsuÃ¡rio','minhastarefa'),(10,110,0,'ParÃ¢metros da AplicaÃ§Ã£o','parametrosaplicacao'),(11,111,0,'Cadastro de Pessoas','pessoa'),(12,112,0,'Cadastro da Prefeitura','prefeitura'),(13,113,0,'Cadastro de Tipos de OcorrÃªncia','tipoocorrencia'),(14,114,0,'Mapa de OcorrÃªncias','mapaocorrencias'),(75,8,0,'teste','teste'),(75,9,2,NULL,NULL);
/*!40000 ALTER TABLE `seg_menu_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_menu_campo`
--

DROP TABLE IF EXISTS `seg_menu_campo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_menu_campo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `id_campo` varchar(60) DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `parametro` varchar(60) DEFAULT NULL,
  `menu` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SEG_MENU_CAMPO_SEG_MENU` (`menu`),
  CONSTRAINT `FK_SEG_MENU_CAMPO_SEG_MENU` FOREIGN KEY (`menu`) REFERENCES `seg_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_menu_campo`
--

LOCK TABLES `seg_menu_campo` WRITE;
/*!40000 ALTER TABLE `seg_menu_campo` DISABLE KEYS */;
/*!40000 ALTER TABLE `seg_menu_campo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_menu_campo_aud`
--

DROP TABLE IF EXISTS `seg_menu_campo_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_menu_campo_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `id_campo` varchar(60) DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `parametro` varchar(60) DEFAULT NULL,
  `menu` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_4473w447knovfj9n0o5te0fe3` (`rev`),
  CONSTRAINT `FK_4473w447knovfj9n0o5te0fe3` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_menu_campo_aud`
--

LOCK TABLES `seg_menu_campo_aud` WRITE;
/*!40000 ALTER TABLE `seg_menu_campo_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `seg_menu_campo_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_perfil`
--

DROP TABLE IF EXISTS `seg_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_perfil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `descricao` varchar(60) NOT NULL,
  `nome` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_perfil`
--

LOCK TABLES `seg_perfil` WRITE;
/*!40000 ALTER TABLE `seg_perfil` DISABLE KEYS */;
INSERT INTO `seg_perfil` VALUES (2,'2017-03-31 14:57:10','admin',2,'Administrador do Sistema','Administrador'),(3,'2017-06-13 14:59:35','admin',3,'Define o acesso dos secretÃ¡rios ao sistema','SecretÃ¡rio');
/*!40000 ALTER TABLE `seg_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_perfil_aud`
--

DROP TABLE IF EXISTS `seg_perfil_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_perfil_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `descricao` varchar(60) DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_efc0re1b8swv269empcr9b1go` (`rev`),
  CONSTRAINT `FK_efc0re1b8swv269empcr9b1go` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_perfil_aud`
--

LOCK TABLES `seg_perfil_aud` WRITE;
/*!40000 ALTER TABLE `seg_perfil_aud` DISABLE KEYS */;
INSERT INTO `seg_perfil_aud` VALUES (1,6,2,NULL,NULL),(2,3,0,'teste perfil','teste perfil'),(2,4,1,'Administrador do Sistema','Administrador 1'),(2,7,1,'Administrador do Sistema','Administrador'),(2,8,1,'Administrador do Sistema','Administrador'),(2,108,1,'Administrador do Sistema','Administrador'),(2,109,1,'Administrador do Sistema','Administrador'),(2,110,1,'Administrador do Sistema','Administrador'),(2,111,1,'Administrador do Sistema','Administrador'),(2,112,1,'Administrador do Sistema','Administrador'),(2,113,1,'Administrador do Sistema','Administrador'),(2,114,1,'Administrador do Sistema','Administrador'),(3,115,0,'Define o acesso dos secretÃ¡rios ao sistema','SecretÃ¡rio');
/*!40000 ALTER TABLE `seg_perfil_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_perfil_menu`
--

DROP TABLE IF EXISTS `seg_perfil_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_perfil_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `data_final` datetime DEFAULT NULL,
  `data_inicial` datetime DEFAULT NULL,
  `tipo_acesso` varchar(3) NOT NULL,
  `menu` bigint(20) DEFAULT NULL,
  `perfil` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SEG_PERFIL_MENU_MENU` (`menu`),
  KEY `FK_SEG_PERFIL_MENU_SEG_PERFIL` (`perfil`),
  CONSTRAINT `FK_SEG_PERFIL_MENU_MENU` FOREIGN KEY (`menu`) REFERENCES `seg_menu` (`id`),
  CONSTRAINT `FK_SEG_PERFIL_MENU_SEG_PERFIL` FOREIGN KEY (`perfil`) REFERENCES `seg_perfil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_perfil_menu`
--

LOCK TABLES `seg_perfil_menu` WRITE;
/*!40000 ALTER TABLE `seg_perfil_menu` DISABLE KEYS */;
INSERT INTO `seg_perfil_menu` VALUES (1,'2017-03-31 14:57:10','admin',2,NULL,NULL,'PER',6,2),(2,'2017-03-31 14:57:10','admin',2,NULL,NULL,'PER',2,2),(3,'2017-03-31 14:57:10','admin',2,NULL,NULL,'PER',3,2),(4,'2017-03-31 14:57:10','admin',2,NULL,NULL,'PER',4,2),(5,'2017-03-31 14:57:10','admin',2,NULL,NULL,'PER',1,2),(6,'2017-03-31 14:57:10','admin',2,NULL,NULL,'PER',7,2),(7,'2017-03-31 14:57:10','admin',2,NULL,NULL,'PER',5,2),(8,'2017-06-09 10:04:59','',0,NULL,NULL,'PER',8,2),(9,'2017-06-09 10:05:22','',0,NULL,NULL,'PER',9,2),(10,'2017-06-09 10:05:38','',0,NULL,NULL,'PER',10,2),(11,'2017-06-09 10:05:51','',0,NULL,NULL,'PER',11,2),(12,'2017-06-09 10:06:07','',0,NULL,NULL,'PER',12,2),(13,'2017-06-09 10:06:29','',0,NULL,NULL,'PER',13,2),(14,'2017-06-09 10:07:05','',0,NULL,NULL,'PER',14,2),(15,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',6,3),(16,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',12,3),(17,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',2,3),(18,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',8,3),(19,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',3,3),(20,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',11,3),(21,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',4,3),(22,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',13,3),(23,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',1,3),(24,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',7,3),(25,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',14,3),(26,'2017-06-13 14:59:35','admin',3,NULL,NULL,'NEG',10,3),(27,'2017-06-13 14:59:35','admin',3,NULL,NULL,'PER',9,3),(28,'2017-06-13 14:59:35','admin',3,NULL,NULL,'PER',5,3);
/*!40000 ALTER TABLE `seg_perfil_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_perfil_menu_acao_negado`
--

DROP TABLE IF EXISTS `seg_perfil_menu_acao_negado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_perfil_menu_acao_negado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `acao` varchar(3) DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `perfil_menu` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SEG_PERFIL_MENU_ACAO_NEGADO_PERFIL_MENU` (`perfil_menu`),
  CONSTRAINT `FK_SEG_PERFIL_MENU_ACAO_NEGADO_PERFIL_MENU` FOREIGN KEY (`perfil_menu`) REFERENCES `seg_perfil_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_perfil_menu_acao_negado`
--

LOCK TABLES `seg_perfil_menu_acao_negado` WRITE;
/*!40000 ALTER TABLE `seg_perfil_menu_acao_negado` DISABLE KEYS */;
/*!40000 ALTER TABLE `seg_perfil_menu_acao_negado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_perfil_menu_acao_negado_aud`
--

DROP TABLE IF EXISTS `seg_perfil_menu_acao_negado_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_perfil_menu_acao_negado_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `acao` varchar(3) DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `perfil_menu` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_gvkkbfp7eq8pjvmjvu198uqw` (`rev`),
  CONSTRAINT `FK_gvkkbfp7eq8pjvmjvu198uqw` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_perfil_menu_acao_negado_aud`
--

LOCK TABLES `seg_perfil_menu_acao_negado_aud` WRITE;
/*!40000 ALTER TABLE `seg_perfil_menu_acao_negado_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `seg_perfil_menu_acao_negado_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_perfil_menu_aud`
--

DROP TABLE IF EXISTS `seg_perfil_menu_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_perfil_menu_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `data_final` datetime DEFAULT NULL,
  `data_inicial` datetime DEFAULT NULL,
  `tipo_acesso` varchar(3) DEFAULT NULL,
  `menu` bigint(20) DEFAULT NULL,
  `perfil` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_3aioa632fvxkilawe900l0s40` (`rev`),
  CONSTRAINT `FK_3aioa632fvxkilawe900l0s40` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_perfil_menu_aud`
--

LOCK TABLES `seg_perfil_menu_aud` WRITE;
/*!40000 ALTER TABLE `seg_perfil_menu_aud` DISABLE KEYS */;
INSERT INTO `seg_perfil_menu_aud` VALUES (1,3,0,NULL,NULL,'PER',6,2),(2,3,0,NULL,NULL,'PER',2,2),(3,3,0,NULL,NULL,'PER',3,2),(4,3,0,NULL,NULL,'PER',4,2),(5,3,0,NULL,NULL,'PER',1,2),(6,3,0,NULL,NULL,'PER',7,2),(7,3,0,NULL,NULL,'PER',5,2),(8,8,0,NULL,NULL,'PER',75,2),(8,108,0,NULL,NULL,'PER',8,2),(9,109,0,NULL,NULL,'PER',9,2),(10,110,0,NULL,NULL,'PER',10,2),(11,111,0,NULL,NULL,'PER',11,2),(12,112,0,NULL,NULL,'PER',12,2),(13,113,0,NULL,NULL,'PER',13,2),(14,114,0,NULL,NULL,'PER',14,2),(15,115,0,NULL,NULL,'PER',6,3),(15,116,1,NULL,NULL,'NEG',6,3),(16,115,0,NULL,NULL,'PER',12,3),(16,116,1,NULL,NULL,'NEG',12,3),(17,115,0,NULL,NULL,'PER',2,3),(17,116,1,NULL,NULL,'NEG',2,3),(17,124,1,NULL,NULL,'PER',2,3),(17,126,1,NULL,NULL,'NEG',2,3),(18,115,0,NULL,NULL,'PER',8,3),(18,116,1,NULL,NULL,'NEG',8,3),(18,124,1,NULL,NULL,'PER',8,3),(18,126,1,NULL,NULL,'NEG',8,3),(19,115,0,NULL,NULL,'PER',3,3),(19,116,1,NULL,NULL,'NEG',3,3),(20,115,0,NULL,NULL,'PER',11,3),(20,116,1,NULL,NULL,'NEG',11,3),(21,115,0,NULL,NULL,'PER',4,3),(21,116,1,NULL,NULL,'NEG',4,3),(22,115,0,NULL,NULL,'PER',13,3),(22,116,1,NULL,NULL,'NEG',13,3),(23,115,0,NULL,NULL,'PER',1,3),(23,116,1,NULL,NULL,'NEG',1,3),(24,115,0,NULL,NULL,'PER',7,3),(24,116,1,NULL,NULL,'NEG',7,3),(25,115,0,NULL,NULL,'PER',14,3),(25,116,1,NULL,NULL,'NEG',14,3),(26,115,0,NULL,NULL,'PER',10,3),(26,116,1,NULL,NULL,'NEG',10,3),(27,115,0,NULL,NULL,'PER',9,3),(28,115,0,NULL,NULL,'PER',5,3);
/*!40000 ALTER TABLE `seg_perfil_menu_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_perfil_menu_campo`
--

DROP TABLE IF EXISTS `seg_perfil_menu_campo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_perfil_menu_campo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `visibilidade_campo` varchar(3) DEFAULT NULL,
  `menu_campo` bigint(20) DEFAULT NULL,
  `perfil_menu` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SEG_PERFIL_MENU_CAMPO_MENU_CAMPO` (`menu_campo`),
  KEY `FK_SEG_PERFIL_MENU_CAMPO_PERFIL_MENU` (`perfil_menu`),
  CONSTRAINT `FK_SEG_PERFIL_MENU_CAMPO_MENU_CAMPO` FOREIGN KEY (`menu_campo`) REFERENCES `seg_menu_campo` (`id`),
  CONSTRAINT `FK_SEG_PERFIL_MENU_CAMPO_PERFIL_MENU` FOREIGN KEY (`perfil_menu`) REFERENCES `seg_perfil_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_perfil_menu_campo`
--

LOCK TABLES `seg_perfil_menu_campo` WRITE;
/*!40000 ALTER TABLE `seg_perfil_menu_campo` DISABLE KEYS */;
/*!40000 ALTER TABLE `seg_perfil_menu_campo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_perfil_menu_campo_aud`
--

DROP TABLE IF EXISTS `seg_perfil_menu_campo_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_perfil_menu_campo_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `visibilidade_campo` varchar(3) DEFAULT NULL,
  `menu_campo` bigint(20) DEFAULT NULL,
  `perfil_menu` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_6rvl6thpo8swoprpjjkfbcfk6` (`rev`),
  CONSTRAINT `FK_6rvl6thpo8swoprpjjkfbcfk6` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_perfil_menu_campo_aud`
--

LOCK TABLES `seg_perfil_menu_campo_aud` WRITE;
/*!40000 ALTER TABLE `seg_perfil_menu_campo_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `seg_perfil_menu_campo_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_usuario`
--

DROP TABLE IF EXISTS `seg_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `bloqueado` tinyint(1) DEFAULT NULL,
  `login_usuario` varchar(50) NOT NULL,
  `perfil` varchar(7) NOT NULL,
  `senha_usuario` varchar(50) NOT NULL,
  `visualiza_todas_ocorrencias` tinyint(1) DEFAULT NULL,
  `pessoa` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_USUARIO_PESSOA` (`pessoa`),
  CONSTRAINT `FK_USUARIO_PESSOA` FOREIGN KEY (`pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_usuario`
--

LOCK TABLES `seg_usuario` WRITE;
/*!40000 ALTER TABLE `seg_usuario` DISABLE KEYS */;
INSERT INTO `seg_usuario` VALUES (1,'2017-06-14 18:50:21','admin',26,0,'admin','Membros','83975272f038b5f46251e2e81867e801',1,14),(2,'2017-06-14 18:50:44','admin',1,0,'thiago','Membros','B072F5E846E2FF738628D448071579C9',0,13);
/*!40000 ALTER TABLE `seg_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_usuario_aud`
--

DROP TABLE IF EXISTS `seg_usuario_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_usuario_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `bloqueado` tinyint(1) DEFAULT NULL,
  `login_usuario` varchar(50) DEFAULT NULL,
  `perfil` varchar(7) DEFAULT NULL,
  `senha_usuario` varchar(50) DEFAULT NULL,
  `visualiza_todas_ocorrencias` tinyint(1) DEFAULT NULL,
  `pessoa` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_1oae8siv6701mmmfrcturuloj` (`rev`),
  CONSTRAINT `FK_1oae8siv6701mmmfrcturuloj` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_usuario_aud`
--

LOCK TABLES `seg_usuario_aud` WRITE;
/*!40000 ALTER TABLE `seg_usuario_aud` DISABLE KEYS */;
INSERT INTO `seg_usuario_aud` VALUES (1,35,1,0,'admin','Membros','202cb962ac59075b964b07152d234b70',1,1),(1,129,1,0,'admin','Membros','E1F29E9122E6D752EE91E993DC2602C9',1,14),(2,117,0,0,'thiago','Membros','E10ADC3949BA59ABBE56E057F20F883E',0,9),(2,130,1,0,'thiago','Membros','B072F5E846E2FF738628D448071579C9',0,13),(4,1,0,0,'usuario_teste','Membros','17003122B89CCB2A3D7D4970DE0D91AE',NULL,NULL),(4,2,2,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `seg_usuario_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_usuario_perfil`
--

DROP TABLE IF EXISTS `seg_usuario_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_usuario_perfil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `data_final` datetime DEFAULT NULL,
  `data_inicial` datetime DEFAULT NULL,
  `perfil` bigint(20) DEFAULT NULL,
  `usuario` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SEGUSUARIOPERFIL_PERFIL` (`perfil`),
  KEY `FK_SEGUSUARIOPERFIL_SEGUSUARIO` (`usuario`),
  CONSTRAINT `FK_SEGUSUARIOPERFIL_PERFIL` FOREIGN KEY (`perfil`) REFERENCES `seg_perfil` (`id`),
  CONSTRAINT `FK_SEGUSUARIOPERFIL_SEGUSUARIO` FOREIGN KEY (`usuario`) REFERENCES `seg_usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_usuario_perfil`
--

LOCK TABLES `seg_usuario_perfil` WRITE;
/*!40000 ALTER TABLE `seg_usuario_perfil` DISABLE KEYS */;
INSERT INTO `seg_usuario_perfil` VALUES (1,'2017-06-14 18:50:21','admin',6,'2018-10-31 00:00:00','2010-10-01 00:00:00',2,1),(2,'2017-06-14 18:50:44','admin',1,'2026-06-01 00:00:00','2017-06-01 00:00:00',3,2);
/*!40000 ALTER TABLE `seg_usuario_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seg_usuario_perfil_aud`
--

DROP TABLE IF EXISTS `seg_usuario_perfil_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_usuario_perfil_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `data_final` datetime DEFAULT NULL,
  `data_inicial` datetime DEFAULT NULL,
  `perfil` bigint(20) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_j8lfsa2p2a2vmd7x9y1cyqecv` (`rev`),
  CONSTRAINT `FK_j8lfsa2p2a2vmd7x9y1cyqecv` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_usuario_perfil_aud`
--

LOCK TABLES `seg_usuario_perfil_aud` WRITE;
/*!40000 ALTER TABLE `seg_usuario_perfil_aud` DISABLE KEYS */;
INSERT INTO `seg_usuario_perfil_aud` VALUES (1,5,1,'2018-10-31 00:00:00','2010-10-01 00:00:00',2,1),(2,1,0,'2017-03-31 00:00:00','2017-03-01 00:00:00',1,4),(2,2,2,NULL,NULL,NULL,NULL),(2,117,0,'2026-06-01 00:00:00','2017-06-01 00:00:00',3,2);
/*!40000 ALTER TABLE `seg_usuario_perfil_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_ocorrencia`
--

DROP TABLE IF EXISTS `tipo_ocorrencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_ocorrencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_ult_alteracao` datetime NOT NULL,
  `usuario_ult_alteracao` varchar(150) NOT NULL,
  `versao` int(11) NOT NULL,
  `descricao` varchar(60) NOT NULL,
  `secretaria_responsavel` varchar(3) NOT NULL,
  `icone` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ICONE_TIPO_OCORRENCIA` (`icone`),
  CONSTRAINT `FK_ICONE_TIPO_OCORRENCIA` FOREIGN KEY (`icone`) REFERENCES `foto_prefeitura` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_ocorrencia`
--

LOCK TABLES `tipo_ocorrencia` WRITE;
/*!40000 ALTER TABLE `tipo_ocorrencia` DISABLE KEYS */;
INSERT INTO `tipo_ocorrencia` VALUES (13,'2017-08-02 12:57:37','admin',1,'Buraco na Via','OBR',NULL),(14,'2017-08-02 12:57:56','admin',1,'SemÃ¡faoro','OBR',NULL),(15,'2017-08-02 13:08:40','admin',1,'Ãgua Parada','SAA',NULL),(16,'2017-08-02 12:58:46','admin',0,'Estacionamento Irregular','OBR',NULL),(17,'2017-08-02 12:59:03','admin',0,'Bloqueio na Via','OBR',NULL),(18,'2017-08-02 12:59:15','admin',0,'SinalizaÃ§Ã£o','OBR',NULL),(19,'2017-08-02 13:00:59','admin',1,'VeÃ­culo Abandonado','OBR',NULL),(20,'2017-08-02 13:00:32','admin',2,'Estradas Rurais','OBR',NULL),(21,'2017-08-02 12:59:42','admin',0,'Lombada','OBR',NULL),(22,'2017-08-02 13:00:43','admin',1,'Deslizamento','OBR',NULL),(23,'2017-08-02 13:00:10','admin',0,'Estradas Urbanas','OBR',NULL),(24,'2017-08-02 13:01:14','admin',0,'FiscalizaÃ§Ã£o de TrÃ¢nsito','OBR',NULL),(25,'2017-08-02 13:01:32','admin',0,'Capina e RoÃ§ada','MEI',NULL),(26,'2017-08-02 13:01:43','admin',0,'Coleta Seletiva','MEI',NULL),(27,'2017-08-02 13:01:56','admin',0,'Canteiros e Jardins','MEI',NULL),(28,'2017-08-02 13:02:06','admin',0,'Limpeza Urbana','MEI',NULL),(29,'2017-08-02 13:02:22','admin',0,'Lixo OrgÃ¢nico','MEI',NULL),(30,'2017-08-02 13:02:37','admin',0,'Lixo Verde','MEI',NULL),(31,'2017-08-02 13:02:47','admin',0,'PraÃ§as','MEI',NULL),(32,'2017-08-02 13:02:56','admin',0,'Parques','MEI',NULL),(33,'2017-08-02 13:03:07','admin',0,'Lixeiras PÃºblicas','MEI',NULL),(34,'2017-08-02 13:03:33','admin',0,'Entulho da CalÃ§ada / via PÃºblica','MEI',NULL),(35,'2017-08-02 13:03:58','admin',0,'FiaÃ§Ã£o Irregular','OBR',NULL),(36,'2017-08-02 13:04:07','admin',0,'Falta de Energia','OBR',NULL),(37,'2017-08-02 13:04:17','admin',0,'Postes / Cabos','OBR',NULL),(38,'2017-08-02 13:04:36','admin',0,'LÃ¢mpada Queimada','OBR',NULL),(39,'2017-08-02 13:05:01','admin',0,'Aterro SanitÃ¡rio Irregular','MEI',NULL),(40,'2017-08-02 13:05:10','admin',0,'Enxames','MEI',NULL),(41,'2017-08-02 13:05:26','admin',0,'Poda / Retirada de Ãrvores','MEI',NULL),(42,'2017-08-02 13:05:39','admin',0,'Queimada / Desmatamento Irregular','MEI',NULL),(43,'2017-08-02 13:05:55','admin',0,'Animais DomÃ©sticos','MEI',NULL),(44,'2017-08-02 13:06:06','admin',0,'Animais PecuÃ¡rios','MEI',NULL),(45,'2017-08-02 13:06:17','admin',0,'FiscalizaÃ§Ã£o Ambiental','MEI',NULL),(46,'2017-08-02 13:06:45','admin',0,'Faixa de Pedestre','OBR',NULL),(47,'2017-08-02 13:06:56','admin',0,'Acessibilidade','OBR',NULL),(48,'2017-08-02 13:07:12','admin',0,'Passarela','OBR',NULL),(49,'2017-08-02 13:07:26','admin',0,'Passeio / CalÃ§ada','OBR',NULL),(50,'2017-08-02 13:07:41','admin',0,'Alagamento','SAA',NULL),(51,'2017-08-02 13:07:51','admin',0,'Falta de Ãgua','SAA',NULL),(52,'2017-08-02 13:08:01','admin',0,'Vazamentos','SAA',NULL),(53,'2017-08-02 13:08:11','admin',0,'Esgoto','SAA',NULL),(54,'2017-08-02 13:08:25','admin',0,'Bueiro / Boca de Lobo','SAA',NULL),(55,'2017-08-02 13:09:11','admin',0,'Escolas','EDU',NULL),(56,'2017-08-02 13:09:24','admin',0,'Atendimento TurÃ­stico','TUR',NULL),(57,'2017-08-02 13:09:35','admin',0,'Cultura','CUL',NULL),(58,'2017-08-02 13:09:49','admin',0,'AssistÃªncia Social','SOC',NULL),(59,'2017-08-02 13:10:00','admin',0,'Esportes','ESP',NULL),(60,'2017-08-02 13:10:24','admin',0,'EstaÃ§Ã£o de Transporte Danificada','OBR',NULL),(61,'2017-08-02 13:10:36','admin',0,'VeÃ­culo de Transporte Danificado','OBR',NULL),(62,'2017-08-02 13:10:51','admin',0,'VeÃ­culo de Transporte Superlotado','OBR',NULL),(63,'2017-08-02 13:11:04','admin',0,'Transporte PÃºblico Irregular','OBR',NULL),(64,'2017-08-02 13:11:22','admin',0,'Foco de Dengue','SAU',NULL),(65,'2017-08-02 13:11:30','admin',0,'Consultas / Exames','SAU',NULL),(66,'2017-08-02 13:12:02','admin',0,'Equipamento PÃºblico Danificado','PLA',NULL),(67,'2017-08-02 13:12:26','admin',0,'ImÃ³vel Abandonado','PLA',NULL),(68,'2017-08-02 13:13:06','admin',0,'Estabelecimento sem Acessibilidade','GAB',NULL),(69,'2017-08-02 13:13:23','admin',0,'Estabelecimento com OcupaÃ§Ã£o Irregular','GAB',NULL),(70,'2017-08-02 13:13:36','admin',0,'PoluiÃ§Ã£o Sonora','GAB',NULL),(71,'2017-08-02 13:13:55','admin',0,'Estabelecimento sem AlvarÃ¡','GAB',NULL),(72,'2017-08-02 13:14:07','admin',0,'Ambulantes','GAB',NULL),(73,'2017-08-02 13:14:17','admin',0,'Obra Irregular','OBR',NULL),(74,'2017-08-02 13:14:29','admin',0,'Publicidade Irregular','GAB',NULL),(75,'2017-08-02 13:14:43','admin',0,'CondiÃ§Ã£o SanitÃ¡ria Irregular','GAB',NULL),(76,'2017-08-02 13:14:56','admin',0,'AlvarÃ¡ SanitÃ¡rio','GAB',NULL),(77,'2017-08-02 13:15:12','admin',0,'EmissÃ£o de Poluentes','GAB',NULL);
/*!40000 ALTER TABLE `tipo_ocorrencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_ocorrencia_aud`
--

DROP TABLE IF EXISTS `tipo_ocorrencia_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_ocorrencia_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `descricao` varchar(60) DEFAULT NULL,
  `secretaria_responsavel` varchar(3) DEFAULT NULL,
  `icone` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK_1mhdeghq60le9iib8b5kv6lsb` (`rev`),
  CONSTRAINT `FK_1mhdeghq60le9iib8b5kv6lsb` FOREIGN KEY (`rev`) REFERENCES `revision` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_ocorrencia_aud`
--

LOCK TABLES `tipo_ocorrencia_aud` WRITE;
/*!40000 ALTER TABLE `tipo_ocorrencia_aud` DISABLE KEYS */;
INSERT INTO `tipo_ocorrencia_aud` VALUES (13,132,0,'Buraco','OBR',NULL),(13,173,1,'Buraco na Via','OBR',NULL),(14,133,0,'IluminaÃ§Ã£o','OBR',NULL),(14,174,1,'SemÃ¡faoro','OBR',NULL),(15,134,0,'Ãgua Parada','MEI',NULL),(15,218,1,'Ãgua Parada','SAA',NULL),(16,175,0,'Estacionamento Irregular','OBR',NULL),(17,176,0,'Bloqueio na Via','OBR',NULL),(18,177,0,'SinalizaÃ§Ã£o','OBR',NULL),(19,178,0,'Deslizamento','OBR',NULL),(19,186,1,'VeÃ­culo Abandonado','OBR',NULL),(20,179,0,'Lombada','OBR',NULL),(20,183,1,'Estratas Rurais','OBR',NULL),(20,184,1,'Estradas Rurais','OBR',NULL),(21,180,0,'Lombada','OBR',NULL),(22,181,0,'Lombada','OBR',NULL),(22,185,1,'Deslizamento','OBR',NULL),(23,182,0,'Estradas Urbanas','OBR',NULL),(24,187,0,'FiscalizaÃ§Ã£o de TrÃ¢nsito','OBR',NULL),(25,188,0,'Capina e RoÃ§ada','MEI',NULL),(26,189,0,'Coleta Seletiva','MEI',NULL),(27,190,0,'Canteiros e Jardins','MEI',NULL),(28,191,0,'Limpeza Urbana','MEI',NULL),(29,192,0,'Lixo OrgÃ¢nico','MEI',NULL),(30,193,0,'Lixo Verde','MEI',NULL),(31,194,0,'PraÃ§as','MEI',NULL),(32,195,0,'Parques','MEI',NULL),(33,196,0,'Lixeiras PÃºblicas','MEI',NULL),(34,197,0,'Entulho da CalÃ§ada / via PÃºblica','MEI',NULL),(35,198,0,'FiaÃ§Ã£o Irregular','OBR',NULL),(36,199,0,'Falta de Energia','OBR',NULL),(37,200,0,'Postes / Cabos','OBR',NULL),(38,201,0,'LÃ¢mpada Queimada','OBR',NULL),(39,202,0,'Aterro SanitÃ¡rio Irregular','MEI',NULL),(40,203,0,'Enxames','MEI',NULL),(41,204,0,'Poda / Retirada de Ãrvores','MEI',NULL),(42,205,0,'Queimada / Desmatamento Irregular','MEI',NULL),(43,206,0,'Animais DomÃ©sticos','MEI',NULL),(44,207,0,'Animais PecuÃ¡rios','MEI',NULL),(45,208,0,'FiscalizaÃ§Ã£o Ambiental','MEI',NULL),(46,209,0,'Faixa de Pedestre','OBR',NULL),(47,210,0,'Acessibilidade','OBR',NULL),(48,211,0,'Passarela','OBR',NULL),(49,212,0,'Passeio / CalÃ§ada','OBR',NULL),(50,213,0,'Alagamento','SAA',NULL),(51,214,0,'Falta de Ãgua','SAA',NULL),(52,215,0,'Vazamentos','SAA',NULL),(53,216,0,'Esgoto','SAA',NULL),(54,217,0,'Bueiro / Boca de Lobo','SAA',NULL),(55,219,0,'Escolas','EDU',NULL),(56,220,0,'Atendimento TurÃ­stico','TUR',NULL),(57,221,0,'Cultura','CUL',NULL),(58,222,0,'AssistÃªncia Social','SOC',NULL),(59,223,0,'Esportes','ESP',NULL),(60,224,0,'EstaÃ§Ã£o de Transporte Danificada','OBR',NULL),(61,225,0,'VeÃ­culo de Transporte Danificado','OBR',NULL),(62,226,0,'VeÃ­culo de Transporte Superlotado','OBR',NULL),(63,227,0,'Transporte PÃºblico Irregular','OBR',NULL),(64,228,0,'Foco de Dengue','SAU',NULL),(65,229,0,'Consultas / Exames','SAU',NULL),(66,230,0,'Equipamento PÃºblico Danificado','PLA',NULL),(67,231,0,'ImÃ³vel Abandonado','PLA',NULL),(68,232,0,'Estabelecimento sem Acessibilidade','GAB',NULL),(69,233,0,'Estabelecimento com OcupaÃ§Ã£o Irregular','GAB',NULL),(70,234,0,'PoluiÃ§Ã£o Sonora','GAB',NULL),(71,235,0,'Estabelecimento sem AlvarÃ¡','GAB',NULL),(72,236,0,'Ambulantes','GAB',NULL),(73,237,0,'Obra Irregular','OBR',NULL),(74,238,0,'Publicidade Irregular','GAB',NULL),(75,239,0,'CondiÃ§Ã£o SanitÃ¡ria Irregular','GAB',NULL),(76,240,0,'AlvarÃ¡ SanitÃ¡rio','GAB',NULL),(77,241,0,'EmissÃ£o de Poluentes','GAB',NULL);
/*!40000 ALTER TABLE `tipo_ocorrencia_aud` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-17 12:54:15
