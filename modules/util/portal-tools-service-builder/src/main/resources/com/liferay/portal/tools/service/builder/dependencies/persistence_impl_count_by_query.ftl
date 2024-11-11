<#assign initialCapacity = entityColumns?size + 1 />

<#if entity.hasLazyReference() && entity.isStrictLazyReference() && !entityFinder.name?contains("_BIS")>
	<#assign initialCapacity += 1 />
</#if>

StringBundler sb = new StringBundler(${initialCapacity});

sb.append(_SQL_COUNT_${entity.alias?upper_case}_WHERE);

<#if entity.hasLazyReference() && entity.isStrictLazyReference() && !entityFinder.name?contains("_BIS")>
	sb.append(_SQL_BATCH_IMPORT_STATUS_WHERE_CLAUSE_AND);
</#if>

<#include "persistence_impl_finder_cols.ftl">