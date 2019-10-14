CREATE TABLE `search` (
  `id` bigint(20) NOT NULL,
  `text` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `id_query` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `query_search` (
  `id` bigint(20) NOT NULL,
  `query` varchar(255) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Indexes for table `search`
--
ALTER TABLE `search`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `query_search`
--
ALTER TABLE `query_search`
  ADD PRIMARY KEY (`id`);
  
--
-- AUTO_INCREMENT for table `search`
--
ALTER TABLE `search`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  
--
-- AUTO_INCREMENT for table `query_search`
--
ALTER TABLE `query_search`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  
-- 
-- Constraint for table search
--
ALTER TABLE `search`
	ADD CONSTRAINT `fk_query_search_id` FOREIGN KEY (`id_query`) REFERENCES `query_search` (`id`);
